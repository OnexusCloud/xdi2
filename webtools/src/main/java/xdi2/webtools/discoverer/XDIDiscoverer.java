package xdi2.webtools.discoverer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xdi2.client.exceptions.Xdi2ClientException;
import xdi2.client.http.XDIHttpClient;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.io.XDIWriter;
import xdi2.core.io.XDIWriterRegistry;
import xdi2.core.io.writers.XDIDisplayWriter;
import xdi2.core.xri3.XDI3Segment;
import xdi2.discovery.XDIDiscoveryClient;
import xdi2.discovery.XDIDiscoveryResult;
import xdi2.messaging.MessageResult;

/**
 * Servlet implementation class for Servlet: XDIDiscoverer
 *
 */
public class XDIDiscoverer extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 216233584449545708L;

	private static Logger log = LoggerFactory.getLogger(XDIDiscoverer.class);

	private static MemoryGraphFactory graphFactory;
	private static List<String> sampleInputs;
	private static String sampleEndpoint;

	static {

		graphFactory = MemoryGraphFactory.getInstance();
		graphFactory.setSortmode(MemoryGraphFactory.SORTMODE_ORDER);

		sampleInputs = Collections.singletonList("=markus");

		sampleEndpoint = "http://mycloud.neustar.biz:12220/"; 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sample = request.getParameter("sample");
		if (sample == null) sample = "1";

		request.setAttribute("sampleInputs", Integer.valueOf(sampleInputs.size()));
		request.setAttribute("resultFormat", XDIDisplayWriter.FORMAT_NAME);
		request.setAttribute("writeImplied", null);
		request.setAttribute("writeOrdered", "on");
		request.setAttribute("writeInner", "on");
		request.setAttribute("writePretty", null);
		request.setAttribute("input", sampleInputs.get(Integer.parseInt(sample) - 1));
		request.setAttribute("endpoint", sampleEndpoint);
		request.setAttribute("authority", "on");

		request.getRequestDispatcher("/XDIDiscoverer.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String resultFormat = request.getParameter("resultFormat");
		String writeImplied = request.getParameter("writeImplied");
		String writeOrdered = request.getParameter("writeOrdered");
		String writeInner = request.getParameter("writeInner");
		String writePretty = request.getParameter("writePretty");
		String input = request.getParameter("input");
		String endpoint = request.getParameter("endpoint");
		String authority = request.getParameter("authority");
		String output = "";
		String output2 = "";
		String stats = "-1";
		String error = null;

		Properties xdiResultWriterParameters = new Properties();

		xdiResultWriterParameters.setProperty(XDIWriterRegistry.PARAMETER_IMPLIED, "on".equals(writeImplied) ? "1" : "0");
		xdiResultWriterParameters.setProperty(XDIWriterRegistry.PARAMETER_ORDERED, "on".equals(writeOrdered) ? "1" : "0");
		xdiResultWriterParameters.setProperty(XDIWriterRegistry.PARAMETER_INNER, "on".equals(writeInner) ? "1" : "0");
		xdiResultWriterParameters.setProperty(XDIWriterRegistry.PARAMETER_PRETTY, "on".equals(writePretty) ? "1" : "0");

		XDIWriter xdiResultWriter = XDIWriterRegistry.forFormat(resultFormat, xdiResultWriterParameters);

		XDIDiscoveryResult discoveryResult1 = null;
		XDIDiscoveryResult discoveryResult2 = null;

		long start = System.currentTimeMillis();

		try {

			// start discovery

			XDIDiscoveryClient discoveryClient = new XDIDiscoveryClient(new XDIHttpClient(endpoint));

			// from registry

			discoveryResult1 = discoveryClient.discoverFromRegistry(XDI3Segment.create(input));

			// from authority

			if ("on".equals(authority)) {

				if (discoveryResult1 != null && discoveryResult1.getXdiEndpointUri() != null) {

					discoveryResult2 = discoveryClient.discoverFromAuthority(discoveryResult1.getXdiEndpointUri(), discoveryResult1.getCloudNumber());
				}
			}

			// output result

			StringWriter writer = new StringWriter();
			StringWriter writer2 = new StringWriter();

			if (discoveryResult1 != null) {

				writer.write("Discovery result from registry:\n\n");

				writer.write("Cloud Number: " + discoveryResult1.getCloudNumber() + "\n");
				writer.write("XDI Endpoint URI: " + discoveryResult1.getXdiEndpointUri() + "\n");
				writer.write("Signature Public Key: " + discoveryResult1.getSignaturePublicKey() + "\n");
				writer.write("Encryption Public Key: " + discoveryResult1.getEncryptionPublicKey() + "\n");
				writer.write("Services: " + discoveryResult1.getServices() + "\n\n");

				writer.write("Message envelope to registry:\n\n");

				if (discoveryResult1.getMessageEnvelope() != null) 
					xdiResultWriter.write(discoveryResult1.getMessageEnvelope().getGraph(), writer);
				else
					writer.write("(null)");

				writer.write("\n");

				writer.write("Message result from registry:\n\n");

				if (discoveryResult1.getMessageResult() != null) 
					xdiResultWriter.write(discoveryResult1.getMessageResult().getGraph(), writer);
				else
					writer.write("(null)");
			} else {

				writer.write("No discovery result from registry.\n");
			}

			if (discoveryResult2 != null) {

				writer2.write("Discovery result from authority:\n\n");

				writer2.write("Cloud Number: " + discoveryResult2.getCloudNumber() + "\n");
				writer2.write("XDI Endpoint URI: " + discoveryResult2.getXdiEndpointUri() + "\n");
				writer.write("Signature Public Key: " + discoveryResult2.getSignaturePublicKey() + "\n");
				writer.write("Encryption Public Key: " + discoveryResult2.getEncryptionPublicKey() + "\n");
				writer2.write("Services: " + discoveryResult2.getServices() + "\n\n");

				writer2.write("Message envelope to authority:\n\n");

				if (discoveryResult2.getMessageEnvelope() != null) 
					xdiResultWriter.write(discoveryResult2.getMessageEnvelope().getGraph(), writer2);
				else
					writer2.write("(null)");

				writer2.write("\n");

				writer2.write("Message result from authority:\n\n");

				if (discoveryResult2.getMessageResult() != null)
					xdiResultWriter.write(discoveryResult2.getMessageResult().getGraph(), writer2);
				else
					writer2.write("(null)");
			} else {

				writer2.write("No discovery result from authority.\n");
			}

			output = StringEscapeUtils.escapeHtml(writer.getBuffer().toString());
			output2 = StringEscapeUtils.escapeHtml(writer2.getBuffer().toString());
		} catch (Exception ex) {

			if (ex instanceof Xdi2ClientException) {

				MessageResult messageResult = ((Xdi2ClientException) ex).getErrorMessageResult();

				// output the message result

				if (messageResult != null) {

					StringWriter writer2 = new StringWriter();
					xdiResultWriter.write(messageResult.getGraph(), writer2);
					output = StringEscapeUtils.escapeHtml(writer2.getBuffer().toString());
				}
			}

			log.error(ex.getMessage(), ex);
			error = ex.getMessage();
			if (error == null) error = ex.getClass().getName();
		}

		long stop = System.currentTimeMillis();

		stats = "";
		stats += Long.toString(stop - start) + " ms time. ";
		if (discoveryResult1 != null && discoveryResult1.getMessageResult() != null) stats += Long.toString(discoveryResult1.getMessageResult().getGraph().getRootContextNode().getAllStatementCount()) + " result statement(s) from registry. ";
		if (discoveryResult2 != null && discoveryResult2.getMessageResult() != null) stats += Long.toString(discoveryResult2.getMessageResult().getGraph().getRootContextNode().getAllStatementCount()) + " result statement(s) from authority. ";

		// display results

		request.setAttribute("sampleInputs", Integer.valueOf(sampleInputs.size()));
		request.setAttribute("resultFormat", resultFormat);
		request.setAttribute("writeImplied", writeImplied);
		request.setAttribute("writeOrdered", writeOrdered);
		request.setAttribute("writeInner", writeInner);
		request.setAttribute("writePretty", writePretty);
		request.setAttribute("input", input);
		request.setAttribute("endpoint", endpoint);
		request.setAttribute("authority", authority);
		request.setAttribute("output", output);
		request.setAttribute("output2", output2);
		request.setAttribute("stats", stats);
		request.setAttribute("error", error);

		request.getRequestDispatcher("/XDIDiscoverer.jsp").forward(request, response);
	}
}

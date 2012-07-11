package xdi2.xri2xdi;

import xdi2.core.ContextNode;
import xdi2.core.Graph;
import xdi2.core.features.remoteroots.RemoteRoots;
import xdi2.core.xri3.impl.XRI3Segment;
import xdi2.core.xri3.impl.XRI3SubSegment;
import xdi2.messaging.MessageResult;
import xdi2.messaging.Operation;
import xdi2.messaging.exceptions.Xdi2MessagingException;
import xdi2.messaging.target.ExecutionContext;
import xdi2.messaging.target.impl.AbstractMessagingTarget;
import xdi2.xri2xdi.resolution.XriResolutionException;
import xdi2.xri2xdi.resolution.XriResolutionResult;
import xdi2.xri2xdi.resolution.XriResolver;

public class Xri2XdiMessagingTarget extends AbstractMessagingTarget {

	private XriResolver xriResolver;

	@Override
	public void init() throws Exception {

		super.init();

		if (this.xriResolver == null) this.xriResolver = new XriResolver();
	}

	@Override
	public boolean executeGetOnAddress(XRI3Segment targetAddress, Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		// is this a remote root context XRI?

		XRI3Segment xri;

		if (RemoteRoots.isRemoteRootXri(targetAddress)) {

			xri = RemoteRoots.getXriOfRemoteRootXri(targetAddress);
		} else {

			xri = targetAddress;
		}

		// resolve the XRI

		XRI3Segment inumber;
		String uri;

		try {

			XriResolutionResult resolutionResult = this.xriResolver.resolve(xri.toString());
			inumber = new XRI3Segment(resolutionResult.getInumber());
			uri = resolutionResult.getUri();
		} catch (XriResolutionException ex) {

			throw new Xdi2MessagingException("XRI Resolution error: " + ex.getMessage(), ex, null);
		}

		// prepare result graph

		Graph graph = messageResult.getGraph();
		ContextNode rootContextNode = graph.getRootContextNode();

		// add "self" remote root context nodes

		ContextNode selfRemoteRootContextNode = RemoteRoots.findRemoteRootContextNode(graph, new XRI3Segment("()"), true);
		selfRemoteRootContextNode.createRelation(new XRI3Segment("$is"), rootContextNode);

		// add I-Number and original XRI remote root context nodes

		ContextNode inumberRemoteRootContextNode = RemoteRoots.findRemoteRootContextNode(graph, inumber, true);
		inumberRemoteRootContextNode.createContextNode(new XRI3SubSegment("$!($uri)")).createLiteral(uri);

		// add I-Number and original XRI

		ContextNode inumberContextNode = graph.findContextNode(inumber, true);

		if (! xri.equals(inumber)) {

			ContextNode xriContextNode = graph.findContextNode(xri, true);
			xriContextNode.createRelation(new XRI3Segment("$is"), inumberContextNode);
		}

		// done

		return true;
	}

	public XriResolver getXriResolver() {

		return this.xriResolver;
	}

	public void setXriResolver(XriResolver xriResolver) {

		this.xriResolver = xriResolver;
	}
}

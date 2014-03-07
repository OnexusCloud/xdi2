package xdi2.core.features.linkcontracts;

import java.util.ArrayList;
import java.util.List;

import xdi2.core.ContextNode;
import xdi2.core.Graph;
import xdi2.core.constants.XDILinkContractConstants;
import xdi2.core.features.nodetypes.XdiAbstractContext;
import xdi2.core.features.nodetypes.XdiAbstractEntity;
import xdi2.core.features.nodetypes.XdiEntity;
import xdi2.core.features.nodetypes.XdiEntityCollection;
import xdi2.core.features.nodetypes.XdiEntityMember;
import xdi2.core.features.nodetypes.XdiEntitySingleton;
import xdi2.core.util.XDI3Util;
import xdi2.core.xri3.XDI3Segment;
import xdi2.core.xri3.XDI3SubSegment;

/**
 * An XDI link contract template, represented as an XDI entity.
 * 
 * @author markus
 */
public class LinkContractTemplate extends LinkContractBase {

	private static final long serialVersionUID = 1373222090414868359L;

	protected LinkContractTemplate(XdiEntity xdiEntity) {

		super(xdiEntity);
	}

	/*
	 * Static methods
	 */

	/**
	 * Checks if an XDI entity is a valid XDI link contract template.
	 * @param xdiEntity The XDI entity to check.
	 * @return True if the XDI entity is a valid XDI link contract template.
	 */
	public static boolean isValid(XdiEntity xdiEntity) {

		if (xdiEntity instanceof XdiEntitySingleton) {

			if (! ((XdiEntitySingleton) xdiEntity).getBaseArcXri().equals(XdiAbstractContext.getBaseArcXri(XDILinkContractConstants.XRI_SS_DO))) return false;

			if (getTemplateAuthority(xdiEntity.getXri()) == null) return false;
			if (getTemplateAuthorityAndId(xdiEntity.getXri()) == null) return false;

			return true;
		} else if (xdiEntity instanceof XdiEntityMember) {

			if (! ((XdiEntityMember) xdiEntity).getXdiCollection().getBaseArcXri().equals(XdiAbstractContext.getBaseArcXri(XDILinkContractConstants.XRI_SS_DO))) return false;

			if (getTemplateAuthority(xdiEntity.getXri()) == null) return false;
			if (getTemplateAuthorityAndId(xdiEntity.getXri()) == null) return false;

			return true;
		} else {

			return false;
		}
	}

	/**
	 * Factory method that creates an XDI link contract template bound to a given XDI entity.
	 * @param xdiEntity The XDI entity that is an XDI link contract template.
	 * @return The XDI link contract template.
	 */
	public static LinkContractTemplate fromXdiEntity(XdiEntity xdiEntity) {

		if (! isValid(xdiEntity)) return null;

		return new LinkContractTemplate(xdiEntity);
	}

	public static XDI3Segment createLinkContractTemplateXri(XDI3Segment templateAuthority, XDI3Segment templateId) {

		List<XDI3SubSegment> linkContractTemplateArcXris = new ArrayList<XDI3SubSegment> ();
		linkContractTemplateArcXris.addAll(templateAuthority.getSubSegments());
		linkContractTemplateArcXris.add(XDILinkContractConstants.XRI_SS_FROM_VARIABLE);
		linkContractTemplateArcXris.addAll(templateAuthority.getSubSegments());
		linkContractTemplateArcXris.addAll(templateId.getSubSegments());
		linkContractTemplateArcXris.add(XDILinkContractConstants.XRI_SS_DO);

		return XDI3Segment.fromComponents(linkContractTemplateArcXris);
	}

	/**
	 * Factory method that finds or creates an XDI link contract template for a graph.
	 * @return The XDI link contract template.
	 */
	public static LinkContractTemplate findLinkContractTemplate(Graph graph, XDI3Segment templateAuthority, XDI3Segment templateId, boolean create) {

		XDI3Segment linkContractTemplateXri = createLinkContractTemplateXri(templateAuthority, templateId);

		ContextNode linkContractTemplateContextNode = create ? graph.setDeepContextNode(linkContractTemplateXri) : graph.getDeepContextNode(linkContractTemplateXri, true);
		if (linkContractTemplateContextNode == null) return null;

		return new LinkContractTemplate(XdiAbstractEntity.fromContextNode(linkContractTemplateContextNode));
	}

	/*
	 * Static methods
	 */

	public static XDI3Segment getTemplateAuthority(XDI3Segment xri) {

		int index = XDI3Util.indexOfXri(xri, XDILinkContractConstants.XRI_SS_FROM_VARIABLE);
		if (index < 0) return null;

		return XDI3Util.subXri(xri, 0, index);
	}

	public static XDI3Segment getTemplateAuthorityAndId(XDI3Segment xri) {

		int index1 = XDI3Util.indexOfXri(xri, XDILinkContractConstants.XRI_SS_FROM_VARIABLE);
		int index2 = XDI3Util.indexOfXri(xri, XDILinkContractConstants.XRI_SS_DO);
		if (index2 < 0) index2 = XDI3Util.indexOfXri(xri, XdiEntityCollection.createArcXri(XDILinkContractConstants.XRI_SS_DO));
		if (index1 < 0 || index2 < 0 || index1 >= index2) return null;

		return XDI3Util.subXri(xri, index1 + 1, index2);
	}

	/*
	 * Instance methods
	 */

	public GenericLinkContract instantiate() {

		throw new RuntimeException("Not implemented.");
	}

	public XDI3Segment getTemplateAuthority() {

		return getTemplateAuthority(this.getContextNode().getXri());
	}

	public XDI3Segment getTemplateAuthorityAndId() {

		return getTemplateAuthorityAndId(this.getContextNode().getXri());
	}
}

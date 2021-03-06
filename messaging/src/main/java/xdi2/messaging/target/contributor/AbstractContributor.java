package xdi2.messaging.target.contributor;

import xdi2.core.util.StatementUtil;
import xdi2.core.util.XDI3Util;
import xdi2.core.xri3.XDI3Segment;
import xdi2.core.xri3.XDI3Statement;
import xdi2.messaging.DelOperation;
import xdi2.messaging.DoOperation;
import xdi2.messaging.GetOperation;
import xdi2.messaging.MessageResult;
import xdi2.messaging.Operation;
import xdi2.messaging.SetOperation;
import xdi2.messaging.context.ExecutionContext;
import xdi2.messaging.exceptions.Xdi2MessagingException;
import xdi2.messaging.target.MessagingTarget;
import xdi2.messaging.target.impl.AbstractExtension;
import xdi2.messaging.target.impl.graph.GraphContextHandler;

public abstract class AbstractContributor extends AbstractExtension<MessagingTarget> implements Contributor {

	private ContributorMap contributors;

	public AbstractContributor(int initPriority, int shutdownPriority) {

		super(initPriority, shutdownPriority);

		this.contributors = new ContributorMap();
	}

	public AbstractContributor() {

		super();

		this.contributors = new ContributorMap ();
	}

	/*
	 * Operations on addresses
	 */

	@Override
	public ContributorResult executeOnAddress(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Segment relativeTargetAddress, Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		// execute on address

		if (operation instanceof GetOperation)
			return this.executeGetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, (GetOperation) operation, messageResult, executionContext);
		else if (operation instanceof SetOperation)
			return this.executeSetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, (SetOperation) operation, messageResult, executionContext);
		else if (operation instanceof DelOperation)
			return this.executeDelOnAddress(contributorXris, contributorsXri, relativeTargetAddress, (DelOperation) operation, messageResult, executionContext);
		else if (operation instanceof DoOperation)
			return this.executeDoOnAddress(contributorXris, contributorsXri, relativeTargetAddress, (DoOperation) operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Unknown operation: " + operation.getOperationXri(), null, executionContext);
	}

	public ContributorResult executeGetOnAddress(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Segment relativeTargetAddress, GetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeSetOnAddress(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Segment relativeTargetAddress, SetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDelOnAddress(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Segment relativeTargetAddress, DelOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDoOnAddress(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Segment relativeTargetAddress, DoOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	/*
	 * Operations on statements
	 */

	@Override
	public ContributorResult executeOnStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, Operation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		// execute on statement

		if (operation instanceof GetOperation)
			return this.executeGetOnStatement(contributorXris, contributorsXri, relativeTargetStatement, (GetOperation) operation, messageResult, executionContext);
		else if (operation instanceof SetOperation)
			return this.executeSetOnStatement(contributorXris, contributorsXri, relativeTargetStatement, (SetOperation) operation, messageResult, executionContext);
		else if (operation instanceof DelOperation)
			return this.executeDelOnStatement(contributorXris, contributorsXri, relativeTargetStatement, (DelOperation) operation, messageResult, executionContext);
		else if (operation instanceof DoOperation)
			return this.executeDoOnStatement(contributorXris, contributorsXri, relativeTargetStatement, (DoOperation) operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Unknown operation: " + operation.getOperationXri(), null, executionContext);
	}

	public ContributorResult executeGetOnStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, GetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		if (relativeTargetStatement.isContextNodeStatement())
			return this.executeGetOnContextNodeStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isRelationStatement())
			return this.executeGetOnRelationStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isLiteralStatement())
			return this.executeGetOnLiteralStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Invalid statement: " + relativeTargetStatement, null, executionContext);
	}

	public ContributorResult executeSetOnStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, SetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		if (relativeTargetStatement.isContextNodeStatement())
			return this.executeSetOnContextNodeStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isRelationStatement())
			return this.executeSetOnRelationStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isLiteralStatement())
			return this.executeSetOnLiteralStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Invalid statement: " + relativeTargetStatement, null, executionContext);
	}

	public ContributorResult executeDelOnStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DelOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		if (relativeTargetStatement.isContextNodeStatement())
			return this.executeDelOnContextNodeStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isRelationStatement())
			return this.executeDelOnRelationStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isLiteralStatement())
			return this.executeDelOnLiteralStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Invalid statement: " + relativeTargetStatement, null, executionContext);
	}

	public ContributorResult executeDoOnStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DoOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		if (relativeTargetStatement.isContextNodeStatement())
			return this.executeDoOnContextNodeStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isRelationStatement())
			return this.executeDoOnRelationStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else if (relativeTargetStatement.isLiteralStatement())
			return this.executeDoOnLiteralStatement(contributorXris, contributorsXri, relativeTargetStatement, operation, messageResult, executionContext);
		else
			throw new Xdi2MessagingException("Invalid statement: " + relativeTargetStatement, null, executionContext);
	}

	/*
	 * Operations on context node statements
	 */

	public ContributorResult executeGetOnContextNodeStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, GetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XDI3Segment relativeTargetAddress = relativeTargetStatement.getContextNodeXri();
		XDI3Statement targetStatement = StatementUtil.concatXriStatement(contributorsXri, relativeTargetStatement, false);

		MessageResult tempMessageResult = new MessageResult();

		ContributorResult contributorResult = this.executeGetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, operation, tempMessageResult, executionContext);

		new GraphContextHandler(tempMessageResult.getGraph()).executeGetOnContextNodeStatement(targetStatement, operation, messageResult, executionContext);

		return contributorResult;
	}

	public ContributorResult executeSetOnContextNodeStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, SetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XDI3Segment relativeTargetAddress = XDI3Util.concatXris(relativeTargetStatement.getContextNodeXri(), relativeTargetStatement.getContextNodeArcXri());

		return this.executeSetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, operation, messageResult, executionContext);
	}

	public ContributorResult executeDelOnContextNodeStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DelOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XDI3Segment relativeTargetAddress = XDI3Util.concatXris(relativeTargetStatement.getContextNodeXri(), relativeTargetStatement.getContextNodeArcXri());

		return this.executeDelOnAddress(contributorXris, contributorsXri, relativeTargetAddress, operation, messageResult, executionContext);
	}

	public ContributorResult executeDoOnContextNodeStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DoOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	/*
	 * Operations on relation statements
	 */

	public ContributorResult executeGetOnRelationStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, GetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XDI3Segment relativeTargetAddress = relativeTargetStatement.getContextNodeXri();
		XDI3Statement targetStatement = StatementUtil.concatXriStatement(contributorsXri, relativeTargetStatement, false);

		MessageResult tempMessageResult = new MessageResult();

		ContributorResult contributorResult = this.executeGetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, operation, tempMessageResult, executionContext);

		new GraphContextHandler(tempMessageResult.getGraph()).executeGetOnRelationStatement(targetStatement, operation, messageResult, executionContext);

		return contributorResult;
	}

	public ContributorResult executeSetOnRelationStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, SetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDelOnRelationStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DelOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDoOnRelationStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DoOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	/*
	 * Operations on literal statements
	 */

	public ContributorResult executeGetOnLiteralStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, GetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		XDI3Segment relativeTargetAddress = relativeTargetStatement.getContextNodeXri();
		XDI3Statement targetStatement = StatementUtil.concatXriStatement(contributorsXri, relativeTargetStatement, false);

		MessageResult tempMessageResult = new MessageResult();

		ContributorResult contributorResult = this.executeGetOnAddress(contributorXris, contributorsXri, relativeTargetAddress, operation, tempMessageResult, executionContext);

		new GraphContextHandler(tempMessageResult.getGraph()).executeGetOnLiteralStatement(targetStatement, operation, messageResult, executionContext);

		return contributorResult;
	}

	public ContributorResult executeSetOnLiteralStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, SetOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDelOnLiteralStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DelOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	public ContributorResult executeDoOnLiteralStatement(XDI3Segment[] contributorXris, XDI3Segment contributorsXri, XDI3Statement relativeTargetStatement, DoOperation operation, MessageResult messageResult, ExecutionContext executionContext) throws Xdi2MessagingException {

		return ContributorResult.DEFAULT;
	}

	/*
	 * Contributor mount
	 */

	@Override
	public ContributorMount getContributorMount() {

		ContributorMount contributorMount = this.getClass().getAnnotation(ContributorMount.class);
		if (contributorMount == null) throw new NullPointerException("No ContributorMount annotation on contributor " + this.getClass().getSimpleName());

		return contributorMount;
	}

	/*
	 * Sub-contributors
	 */

	@Override
	public ContributorMap getContributors() {

		return this.contributors;
	}

	@Override
	public void setContributors(ContributorMap contributors) {

		this.contributors = contributors;
	}
}

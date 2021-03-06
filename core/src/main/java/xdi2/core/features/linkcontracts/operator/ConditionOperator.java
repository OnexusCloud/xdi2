package xdi2.core.features.linkcontracts.operator;

import java.util.Iterator;

import xdi2.core.Relation;
import xdi2.core.Statement;
import xdi2.core.exceptions.Xdi2RuntimeException;
import xdi2.core.features.linkcontracts.condition.Condition;
import xdi2.core.features.nodetypes.XdiInnerRoot;
import xdi2.core.features.nodetypes.XdiRoot.MappingAbsoluteToRelativeStatementXriIterator;
import xdi2.core.util.iterators.MappingIterator;
import xdi2.core.util.iterators.MappingStatementXriIterator;
import xdi2.core.util.iterators.SelectingNotImpliedStatementIterator;
import xdi2.core.xri3.XDI3Statement;

public abstract class ConditionOperator extends Operator {

	private static final long serialVersionUID = 8705917224635642985L;

	protected ConditionOperator(Relation relation) {

		super(relation);
	}

	/**
	 * Returns the XDI conditions of the XDI policy statement.
	 * @return The XDI conditions of the XDI policy statement.
	 */
	public Iterator<Condition> getConditions() {

		XdiInnerRoot innerRoot = XdiInnerRoot.fromContextNode(this.getRelation().follow());
		if (innerRoot == null) throw new Xdi2RuntimeException("Missing condition in operator: " + this.getRelation());

		return new MappingIterator<XDI3Statement, Condition> (
				new MappingAbsoluteToRelativeStatementXriIterator(
						innerRoot,
						new MappingStatementXriIterator(
								new SelectingNotImpliedStatementIterator<Statement> (
										innerRoot.getContextNode().getAllStatements())))) {

			@Override
			public Condition map(XDI3Statement statementXri) {

				return Condition.fromStatement(statementXri);
			}
		};
	}
}

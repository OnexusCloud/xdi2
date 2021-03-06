package xdi2.core.impl.wrapped;

import java.util.Iterator;

import xdi2.core.ContextNode;
import xdi2.core.Literal;
import xdi2.core.Relation;
import xdi2.core.impl.AbstractContextNode;
import xdi2.core.impl.memory.MemoryContextNode;
import xdi2.core.impl.memory.MemoryLiteral;
import xdi2.core.impl.memory.MemoryRelation;
import xdi2.core.util.iterators.MappingIterator;
import xdi2.core.util.iterators.ReadOnlyIterator;
import xdi2.core.xri3.XDI3Segment;
import xdi2.core.xri3.XDI3SubSegment;

public class WrappedContextNode extends AbstractContextNode implements ContextNode {

	private static final long serialVersionUID = 4930852359817860369L;

	private MemoryContextNode memoryContextNode;

	WrappedContextNode(WrappedGraph graph, WrappedContextNode contextNode, MemoryContextNode memoryContextNode) {

		super(graph, contextNode);

		this.memoryContextNode = memoryContextNode;
	}

	@Override
	public XDI3SubSegment getArcXri() {

		return this.memoryContextNode.getArcXri();
	}

	/*
	 * Methods related to context nodes of this context node
	 */

	@Override
	public synchronized ContextNode setContextNode(XDI3SubSegment arcXri) {

		MemoryContextNode ret = (MemoryContextNode) this.memoryContextNode.setContextNode(arcXri);

		return new WrappedContextNode((WrappedGraph) this.getGraph(), this, ret);
	}

	@Override
	public ContextNode getContextNode(XDI3SubSegment arcXri, boolean subgraph) {

		MemoryContextNode ret = (MemoryContextNode) this.memoryContextNode.getContextNode(arcXri, subgraph);

		return ret == null ? null : new WrappedContextNode((WrappedGraph) this.getGraph(), this, ret);
	}

	@Override
	public ReadOnlyIterator<ContextNode> getContextNodes() {

		ReadOnlyIterator<ContextNode> ret = this.memoryContextNode.getContextNodes();

		return new ReadOnlyIterator<ContextNode> (new WrappedContextNodeMappingIterator(ret));
	}

	@Override
	public boolean containsContextNode(XDI3SubSegment arcXri) {

		return this.memoryContextNode.containsContextNode(arcXri);
	}

	@Override
	public boolean containsContextNodes() {

		return this.memoryContextNode.containsContextNodes();
	}

	@Override
	public synchronized void delContextNode(XDI3SubSegment arcXri) {

		this.memoryContextNode.delContextNode(arcXri);
	}

	@Override
	public synchronized void delContextNodes() {

		this.memoryContextNode.delContextNodes();
	}

	/*
	 * Methods related to relations of this context node
	 */

	@Override
	public synchronized Relation setRelation(XDI3Segment arcXri, ContextNode targetContextNode) {

		MemoryRelation ret = (MemoryRelation) this.memoryContextNode.setRelation(arcXri, targetContextNode);

		return new WrappedRelation(this, ret);
	}

	@Override
	public Relation getRelation(XDI3Segment arcXri, XDI3Segment targetContextNodeXri) {

		MemoryRelation ret = (MemoryRelation) this.memoryContextNode.getRelation(arcXri, targetContextNodeXri);

		return ret == null ? null : new WrappedRelation(this, ret);
	}

	@Override
	public ReadOnlyIterator<Relation> getRelations(XDI3Segment arcXri) {

		ReadOnlyIterator<Relation> ret = this.memoryContextNode.getRelations(arcXri);

		return new ReadOnlyIterator<Relation> (new WrappedRelationMappingIterator(ret));
	}

	@Override
	public ReadOnlyIterator<Relation> getRelations() {

		ReadOnlyIterator<Relation> ret = this.memoryContextNode.getRelations();

		return new ReadOnlyIterator<Relation> (new WrappedRelationMappingIterator(ret));
	}

	@Override
	public boolean containsRelation(XDI3Segment arcXri, XDI3Segment targetContextNodeXri) {

		return this.memoryContextNode.containsRelation(arcXri, targetContextNodeXri);
	}

	@Override
	public boolean containsRelations(XDI3Segment arcXri) {

		return this.memoryContextNode.containsRelations(arcXri);
	}

	@Override
	public boolean containsRelations() {

		return this.memoryContextNode.containsRelations();
	}

	@Override
	public synchronized void delRelation(XDI3Segment arcXri, XDI3Segment targetContextNodeXri) {

		this.memoryContextNode.delRelation(arcXri, targetContextNodeXri);
	}

	@Override
	public synchronized void delRelations(XDI3Segment arcXri) {

		this.memoryContextNode.delRelations(arcXri);
	}

	@Override
	public synchronized void delRelations() {

		this.memoryContextNode.delRelations();
	}

	/*
	 * Methods related to literals of this context node
	 */

	@Override
	public synchronized Literal setLiteral(Object literalData) {

		MemoryLiteral ret = (MemoryLiteral) this.memoryContextNode.setLiteral(literalData);

		return ret == null ? null : new WrappedLiteral(this, ret);
	}

	@Override
	public Literal getLiteral() {

		MemoryLiteral ret = (MemoryLiteral) this.memoryContextNode.getLiteral();

		return ret == null ? null : new WrappedLiteral(this, ret);
	}

	@Override
	public boolean containsLiteral() {

		return this.memoryContextNode.containsLiteral();
	}

	@Override
	public synchronized void delLiteral() {

		this.memoryContextNode.delLiteral();
	}

	private class WrappedContextNodeMappingIterator extends MappingIterator<ContextNode, ContextNode> {

		public WrappedContextNodeMappingIterator(Iterator<ContextNode> iterator) {

			super(iterator);
		}

		@Override
		public ContextNode map(ContextNode memoryContextNode) {

			return new WrappedContextNode((WrappedGraph) WrappedContextNode.this.getGraph(), WrappedContextNode.this, (MemoryContextNode) memoryContextNode);
		}
	}

	private class WrappedRelationMappingIterator extends MappingIterator<Relation, Relation> {

		public WrappedRelationMappingIterator(Iterator<Relation> iterator) {

			super(iterator);
		}

		@Override
		public Relation map(Relation memoryRelation) {

			return new WrappedRelation(WrappedContextNode.this, (MemoryRelation) memoryRelation);
		}
	}
}

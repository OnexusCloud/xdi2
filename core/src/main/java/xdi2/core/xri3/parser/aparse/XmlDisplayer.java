/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.3
 * Produced : Mon Apr 22 13:14:58 CEST 2013
 *
 * -----------------------------------------------------------------------------
 */

package xdi2.core.xri3.parser.aparse;

import java.util.ArrayList;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

  public Object visit(Rule_xdi_graph rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<xdi-graph>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</xdi-graph>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_xdi_statement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<xdi-statement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</xdi-statement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_contextual_statement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<contextual-statement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</contextual-statement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_direct_contextual rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<direct-contextual>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</direct-contextual>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_inverse_contextual rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<inverse-contextual>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</inverse-contextual>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_absolute rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<absolute>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</absolute>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_root_relative rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<root-relative>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</root-relative>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_context_relative rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<context-relative>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</context-relative>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_class_relative rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<class-relative>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</class-relative>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_absolute_inverse rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<absolute-inverse>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</absolute-inverse>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_root_inverse rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<root-inverse>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</root-inverse>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_context_inverse rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<context-inverse>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</context-inverse>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_class_inverse rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<class-inverse>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</class-inverse>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_relational_statement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<relational-statement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</relational-statement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_direct_relational rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<direct-relational>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</direct-relational>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_inverse_relational rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<inverse-relational>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</inverse-relational>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_literal_statement rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<literal-statement>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</literal-statement>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_context rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<context>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</context>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_relative_context rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<relative-context>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</relative-context>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_class_context rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<class-context>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</class-context>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_class_path rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<class-path>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</class-path>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_instance_context rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<instance-context>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</instance-context>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_literal_context rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<literal-context>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</literal-context>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_literal_path rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<literal-path>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</literal-path>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_attribute_path rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<attribute-path>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</attribute-path>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_outer_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<outer-root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</outer-root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_relative_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<relative-root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</relative-root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_peer_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<peer-root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</peer-root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_inner_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<inner-root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</inner-root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_statement_root rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<statement-root>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</statement-root>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_xref rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<xref>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</xref>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_subpath rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<subpath>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</subpath>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_subsegment rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<subsegment>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</subsegment>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_entity_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<entity-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</entity-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_authority_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<authority-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</authority-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_type_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<type-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</type-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_person_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<person-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</person-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_group_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<group-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</group-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_reserved_type rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<reserved-type>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</reserved-type>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_unreserved_type rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<unreserved-type>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</unreserved-type>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_attribute_singleton rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<attribute-singleton>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</attribute-singleton>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_meta_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<meta-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</meta-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_reserved_meta_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<reserved-meta-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</reserved-meta-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_unreserved_meta_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<unreserved-meta-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</unreserved-meta-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_concrete_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<concrete-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</concrete-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_entity_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<entity-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</entity-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_authority_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<authority-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</authority-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_type_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<type-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</type-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_instance_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<instance-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</instance-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_reserved_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<reserved-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</reserved-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_unreserved_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<unreserved-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</unreserved-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_person_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<person-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</person-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_group_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<group-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</group-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_mutable_id_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mutable-id-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mutable-id-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_immutable_id_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<immutable-id-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</immutable-id-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_attribute_class rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<attribute-class>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</attribute-class>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_instance rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<instance>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</instance>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ordered_instance rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ordered-instance>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ordered-instance>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_unordered_instance rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<unordered-instance>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</unordered-instance>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_mutable_id rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<mutable-id>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</mutable-id>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_immutable_id rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<immutable-id>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</immutable-id>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_definition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<definition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</definition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_authority_definition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<authority-definition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</authority-definition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_authority_path rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<authority-path>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</authority-path>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_type_definition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<type-definition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</type-definition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_entity_definition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<entity-definition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</entity-definition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_attribute_definition rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<attribute-definition>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</attribute-definition>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_variable rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<variable>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</variable>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_value rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-value>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-value>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_string rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-string>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-string>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_number rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-number>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-number>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_boolean rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-boolean>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-boolean>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_array rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-array>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-array>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_json_object rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<json-object>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</json-object>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ipv6_literal rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ipv6-literal>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ipv6-literal>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_uuid_literal rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<uuid-literal>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</uuid-literal>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_time_low rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<time-low>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</time-low>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_time_mid rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<time-mid>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</time-mid>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_time_high rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<time-high>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</time-high>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_clock_seq rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<clock-seq>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</clock-seq>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_clock_seq_low rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<clock-seq-low>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</clock-seq-low>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_node rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<node>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</node>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_iri_char rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<iri-char>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</iri-char>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_nonparen_delim rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<nonparen-delim>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</nonparen-delim>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_context_symbol rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<context-symbol>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</context-symbol>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_xdi_char rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<xdi-char>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</xdi-char>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ALPHA rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<ALPHA>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</ALPHA>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DIGIT rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DIGIT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DIGIT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HEXDIG rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<HEXDIG>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</HEXDIG>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CRLF rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<CRLF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</CRLF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DQUOTE rule)
  {
    if (!terminal) System.out.println();
    System.out.print("<DQUOTE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) System.out.println();
    System.out.print("</DQUOTE>");
    terminal = false;
    return null;
  }

  public Object visit(Terminal_StringValue value)
  {
    System.out.print(value.spelling);
    terminal = true;
    return null;
  }

  public Object visit(Terminal_NumericValue value)
  {
    System.out.print(value.spelling);
    terminal = true;
    return null;
  }

  private Boolean visitRules(ArrayList<Rule> rules)
  {
    for (Rule rule : rules)
      rule.accept(this);
    return null;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */

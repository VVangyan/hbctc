package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuyItemInfoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BuyItemInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andByintemidIsNull() {
            addCriterion("byIntemId is null");
            return (Criteria) this;
        }

        public Criteria andByintemidIsNotNull() {
            addCriterion("byIntemId is not null");
            return (Criteria) this;
        }

        public Criteria andByintemidEqualTo(Integer value) {
            addCriterion("byIntemId =", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidNotEqualTo(Integer value) {
            addCriterion("byIntemId <>", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidGreaterThan(Integer value) {
            addCriterion("byIntemId >", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("byIntemId >=", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidLessThan(Integer value) {
            addCriterion("byIntemId <", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidLessThanOrEqualTo(Integer value) {
            addCriterion("byIntemId <=", value, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidIn(List<Integer> values) {
            addCriterion("byIntemId in", values, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidNotIn(List<Integer> values) {
            addCriterion("byIntemId not in", values, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidBetween(Integer value1, Integer value2) {
            addCriterion("byIntemId between", value1, value2, "byintemid");
            return (Criteria) this;
        }

        public Criteria andByintemidNotBetween(Integer value1, Integer value2) {
            addCriterion("byIntemId not between", value1, value2, "byintemid");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameIsNull() {
            addCriterion("buyItemName is null");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameIsNotNull() {
            addCriterion("buyItemName is not null");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameEqualTo(String value) {
            addCriterion("buyItemName =", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameNotEqualTo(String value) {
            addCriterion("buyItemName <>", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameGreaterThan(String value) {
            addCriterion("buyItemName >", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameGreaterThanOrEqualTo(String value) {
            addCriterion("buyItemName >=", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameLessThan(String value) {
            addCriterion("buyItemName <", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameLessThanOrEqualTo(String value) {
            addCriterion("buyItemName <=", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameLike(String value) {
            addCriterion("buyItemName like", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameNotLike(String value) {
            addCriterion("buyItemName not like", value, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameIn(List<String> values) {
            addCriterion("buyItemName in", values, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameNotIn(List<String> values) {
            addCriterion("buyItemName not in", values, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameBetween(String value1, String value2) {
            addCriterion("buyItemName between", value1, value2, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemnameNotBetween(String value1, String value2) {
            addCriterion("buyItemName not between", value1, value2, "buyitemname");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyIsNull() {
            addCriterion("buyItemQty is null");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyIsNotNull() {
            addCriterion("buyItemQty is not null");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyEqualTo(Integer value) {
            addCriterion("buyItemQty =", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyNotEqualTo(Integer value) {
            addCriterion("buyItemQty <>", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyGreaterThan(Integer value) {
            addCriterion("buyItemQty >", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyItemQty >=", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyLessThan(Integer value) {
            addCriterion("buyItemQty <", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyLessThanOrEqualTo(Integer value) {
            addCriterion("buyItemQty <=", value, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyIn(List<Integer> values) {
            addCriterion("buyItemQty in", values, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyNotIn(List<Integer> values) {
            addCriterion("buyItemQty not in", values, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyBetween(Integer value1, Integer value2) {
            addCriterion("buyItemQty between", value1, value2, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("buyItemQty not between", value1, value2, "buyitemqty");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitIsNull() {
            addCriterion("buyItemUnit is null");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitIsNotNull() {
            addCriterion("buyItemUnit is not null");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitEqualTo(String value) {
            addCriterion("buyItemUnit =", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitNotEqualTo(String value) {
            addCriterion("buyItemUnit <>", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitGreaterThan(String value) {
            addCriterion("buyItemUnit >", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitGreaterThanOrEqualTo(String value) {
            addCriterion("buyItemUnit >=", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitLessThan(String value) {
            addCriterion("buyItemUnit <", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitLessThanOrEqualTo(String value) {
            addCriterion("buyItemUnit <=", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitLike(String value) {
            addCriterion("buyItemUnit like", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitNotLike(String value) {
            addCriterion("buyItemUnit not like", value, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitIn(List<String> values) {
            addCriterion("buyItemUnit in", values, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitNotIn(List<String> values) {
            addCriterion("buyItemUnit not in", values, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitBetween(String value1, String value2) {
            addCriterion("buyItemUnit between", value1, value2, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemunitNotBetween(String value1, String value2) {
            addCriterion("buyItemUnit not between", value1, value2, "buyitemunit");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumIsNull() {
            addCriterion("buyItemSum is null");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumIsNotNull() {
            addCriterion("buyItemSum is not null");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumEqualTo(Double value) {
            addCriterion("buyItemSum =", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumNotEqualTo(Double value) {
            addCriterion("buyItemSum <>", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumGreaterThan(Double value) {
            addCriterion("buyItemSum >", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumGreaterThanOrEqualTo(Double value) {
            addCriterion("buyItemSum >=", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumLessThan(Double value) {
            addCriterion("buyItemSum <", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumLessThanOrEqualTo(Double value) {
            addCriterion("buyItemSum <=", value, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumIn(List<Double> values) {
            addCriterion("buyItemSum in", values, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumNotIn(List<Double> values) {
            addCriterion("buyItemSum not in", values, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumBetween(Double value1, Double value2) {
            addCriterion("buyItemSum between", value1, value2, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemsumNotBetween(Double value1, Double value2) {
            addCriterion("buyItemSum not between", value1, value2, "buyitemsum");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeIsNull() {
            addCriterion("buyItemType is null");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeIsNotNull() {
            addCriterion("buyItemType is not null");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeEqualTo(String value) {
            addCriterion("buyItemType =", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeNotEqualTo(String value) {
            addCriterion("buyItemType <>", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeGreaterThan(String value) {
            addCriterion("buyItemType >", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeGreaterThanOrEqualTo(String value) {
            addCriterion("buyItemType >=", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeLessThan(String value) {
            addCriterion("buyItemType <", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeLessThanOrEqualTo(String value) {
            addCriterion("buyItemType <=", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeLike(String value) {
            addCriterion("buyItemType like", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeNotLike(String value) {
            addCriterion("buyItemType not like", value, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeIn(List<String> values) {
            addCriterion("buyItemType in", values, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeNotIn(List<String> values) {
            addCriterion("buyItemType not in", values, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeBetween(String value1, String value2) {
            addCriterion("buyItemType between", value1, value2, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andBuyitemtypeNotBetween(String value1, String value2) {
            addCriterion("buyItemType not between", value1, value2, "buyitemtype");
            return (Criteria) this;
        }

        public Criteria andIsimportIsNull() {
            addCriterion("isImport is null");
            return (Criteria) this;
        }

        public Criteria andIsimportIsNotNull() {
            addCriterion("isImport is not null");
            return (Criteria) this;
        }

        public Criteria andIsimportEqualTo(String value) {
            addCriterion("isImport =", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportNotEqualTo(String value) {
            addCriterion("isImport <>", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportGreaterThan(String value) {
            addCriterion("isImport >", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportGreaterThanOrEqualTo(String value) {
            addCriterion("isImport >=", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportLessThan(String value) {
            addCriterion("isImport <", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportLessThanOrEqualTo(String value) {
            addCriterion("isImport <=", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportLike(String value) {
            addCriterion("isImport like", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportNotLike(String value) {
            addCriterion("isImport not like", value, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportIn(List<String> values) {
            addCriterion("isImport in", values, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportNotIn(List<String> values) {
            addCriterion("isImport not in", values, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportBetween(String value1, String value2) {
            addCriterion("isImport between", value1, value2, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsimportNotBetween(String value1, String value2) {
            addCriterion("isImport not between", value1, value2, "isimport");
            return (Criteria) this;
        }

        public Criteria andIsenergyIsNull() {
            addCriterion("isEnergy is null");
            return (Criteria) this;
        }

        public Criteria andIsenergyIsNotNull() {
            addCriterion("isEnergy is not null");
            return (Criteria) this;
        }

        public Criteria andIsenergyEqualTo(String value) {
            addCriterion("isEnergy =", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyNotEqualTo(String value) {
            addCriterion("isEnergy <>", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyGreaterThan(String value) {
            addCriterion("isEnergy >", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyGreaterThanOrEqualTo(String value) {
            addCriterion("isEnergy >=", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyLessThan(String value) {
            addCriterion("isEnergy <", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyLessThanOrEqualTo(String value) {
            addCriterion("isEnergy <=", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyLike(String value) {
            addCriterion("isEnergy like", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyNotLike(String value) {
            addCriterion("isEnergy not like", value, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyIn(List<String> values) {
            addCriterion("isEnergy in", values, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyNotIn(List<String> values) {
            addCriterion("isEnergy not in", values, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyBetween(String value1, String value2) {
            addCriterion("isEnergy between", value1, value2, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenergyNotBetween(String value1, String value2) {
            addCriterion("isEnergy not between", value1, value2, "isenergy");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentIsNull() {
            addCriterion("isEnvironment is null");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentIsNotNull() {
            addCriterion("isEnvironment is not null");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentEqualTo(String value) {
            addCriterion("isEnvironment =", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentNotEqualTo(String value) {
            addCriterion("isEnvironment <>", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentGreaterThan(String value) {
            addCriterion("isEnvironment >", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("isEnvironment >=", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentLessThan(String value) {
            addCriterion("isEnvironment <", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentLessThanOrEqualTo(String value) {
            addCriterion("isEnvironment <=", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentLike(String value) {
            addCriterion("isEnvironment like", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentNotLike(String value) {
            addCriterion("isEnvironment not like", value, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentIn(List<String> values) {
            addCriterion("isEnvironment in", values, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentNotIn(List<String> values) {
            addCriterion("isEnvironment not in", values, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentBetween(String value1, String value2) {
            addCriterion("isEnvironment between", value1, value2, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andIsenvironmentNotBetween(String value1, String value2) {
            addCriterion("isEnvironment not between", value1, value2, "isenvironment");
            return (Criteria) this;
        }

        public Criteria andPreidIsNull() {
            addCriterion("preId is null");
            return (Criteria) this;
        }

        public Criteria andPreidIsNotNull() {
            addCriterion("preId is not null");
            return (Criteria) this;
        }

        public Criteria andPreidEqualTo(Integer value) {
            addCriterion("preId =", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotEqualTo(Integer value) {
            addCriterion("preId <>", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidGreaterThan(Integer value) {
            addCriterion("preId >", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preId >=", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidLessThan(Integer value) {
            addCriterion("preId <", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidLessThanOrEqualTo(Integer value) {
            addCriterion("preId <=", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidIn(List<Integer> values) {
            addCriterion("preId in", values, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotIn(List<Integer> values) {
            addCriterion("preId not in", values, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidBetween(Integer value1, Integer value2) {
            addCriterion("preId between", value1, value2, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotBetween(Integer value1, Integer value2) {
            addCriterion("preId not between", value1, value2, "preid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
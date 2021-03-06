package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DepartmentExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public DepartmentExample() {
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

        public Criteria andDetpnameIsNull() {
            addCriterion("detpname is null");
            return (Criteria) this;
        }

        public Criteria andDetpnameIsNotNull() {
            addCriterion("detpname is not null");
            return (Criteria) this;
        }

        public Criteria andDetpnameEqualTo(String value) {
            addCriterion("detpname =", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameNotEqualTo(String value) {
            addCriterion("detpname <>", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameGreaterThan(String value) {
            addCriterion("detpname >", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameGreaterThanOrEqualTo(String value) {
            addCriterion("detpname >=", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameLessThan(String value) {
            addCriterion("detpname <", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameLessThanOrEqualTo(String value) {
            addCriterion("detpname <=", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameLike(String value) {
            addCriterion("detpname like", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameNotLike(String value) {
            addCriterion("detpname not like", value, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameIn(List<String> values) {
            addCriterion("detpname in", values, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameNotIn(List<String> values) {
            addCriterion("detpname not in", values, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameBetween(String value1, String value2) {
            addCriterion("detpname between", value1, value2, "detpname");
            return (Criteria) this;
        }

        public Criteria andDetpnameNotBetween(String value1, String value2) {
            addCriterion("detpname not between", value1, value2, "detpname");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNull() {
            addCriterion("deptno is null");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNotNull() {
            addCriterion("deptno is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnoEqualTo(String value) {
            addCriterion("deptno =", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotEqualTo(String value) {
            addCriterion("deptno <>", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThan(String value) {
            addCriterion("deptno >", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThanOrEqualTo(String value) {
            addCriterion("deptno >=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThan(String value) {
            addCriterion("deptno <", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThanOrEqualTo(String value) {
            addCriterion("deptno <=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLike(String value) {
            addCriterion("deptno like", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotLike(String value) {
            addCriterion("deptno not like", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoIn(List<String> values) {
            addCriterion("deptno in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotIn(List<String> values) {
            addCriterion("deptno not in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoBetween(String value1, String value2) {
            addCriterion("deptno between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotBetween(String value1, String value2) {
            addCriterion("deptno not between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andPreidIsNull() {
            addCriterion("preid is null");
            return (Criteria) this;
        }

        public Criteria andPreidIsNotNull() {
            addCriterion("preid is not null");
            return (Criteria) this;
        }

        public Criteria andPreidEqualTo(Integer value) {
            addCriterion("preid =", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotEqualTo(Integer value) {
            addCriterion("preid <>", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidGreaterThan(Integer value) {
            addCriterion("preid >", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preid >=", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidLessThan(Integer value) {
            addCriterion("preid <", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidLessThanOrEqualTo(Integer value) {
            addCriterion("preid <=", value, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidIn(List<Integer> values) {
            addCriterion("preid in", values, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotIn(List<Integer> values) {
            addCriterion("preid not in", values, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidBetween(Integer value1, Integer value2) {
            addCriterion("preid between", value1, value2, "preid");
            return (Criteria) this;
        }

        public Criteria andPreidNotBetween(Integer value1, Integer value2) {
            addCriterion("preid not between", value1, value2, "preid");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptIsNull() {
            addCriterion("ismiddledept is null");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptIsNotNull() {
            addCriterion("ismiddledept is not null");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptEqualTo(Integer value) {
            addCriterion("ismiddledept =", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptNotEqualTo(Integer value) {
            addCriterion("ismiddledept <>", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptGreaterThan(Integer value) {
            addCriterion("ismiddledept >", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("ismiddledept >=", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptLessThan(Integer value) {
            addCriterion("ismiddledept <", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptLessThanOrEqualTo(Integer value) {
            addCriterion("ismiddledept <=", value, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptIn(List<Integer> values) {
            addCriterion("ismiddledept in", values, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptNotIn(List<Integer> values) {
            addCriterion("ismiddledept not in", values, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptBetween(Integer value1, Integer value2) {
            addCriterion("ismiddledept between", value1, value2, "ismiddledept");
            return (Criteria) this;
        }

        public Criteria andIsmiddledeptNotBetween(Integer value1, Integer value2) {
            addCriterion("ismiddledept not between", value1, value2, "ismiddledept");
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
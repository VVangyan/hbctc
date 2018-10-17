package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsedMoneyRecordExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UsedMoneyRecordExample() {
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

        public Criteria andUsedMoneyIsNull() {
            addCriterion("used_money is null");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyIsNotNull() {
            addCriterion("used_money is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyEqualTo(Double value) {
            addCriterion("used_money =", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyNotEqualTo(Double value) {
            addCriterion("used_money <>", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyGreaterThan(Double value) {
            addCriterion("used_money >", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("used_money >=", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyLessThan(Double value) {
            addCriterion("used_money <", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyLessThanOrEqualTo(Double value) {
            addCriterion("used_money <=", value, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyIn(List<Double> values) {
            addCriterion("used_money in", values, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyNotIn(List<Double> values) {
            addCriterion("used_money not in", values, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyBetween(Double value1, Double value2) {
            addCriterion("used_money between", value1, value2, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andUsedMoneyNotBetween(Double value1, Double value2) {
            addCriterion("used_money not between", value1, value2, "usedMoney");
            return (Criteria) this;
        }

        public Criteria andFundfromIdIsNull() {
            addCriterion("fundfrom_id is null");
            return (Criteria) this;
        }

        public Criteria andFundfromIdIsNotNull() {
            addCriterion("fundfrom_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundfromIdEqualTo(Integer value) {
            addCriterion("fundfrom_id =", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdNotEqualTo(Integer value) {
            addCriterion("fundfrom_id <>", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdGreaterThan(Integer value) {
            addCriterion("fundfrom_id >", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fundfrom_id >=", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdLessThan(Integer value) {
            addCriterion("fundfrom_id <", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdLessThanOrEqualTo(Integer value) {
            addCriterion("fundfrom_id <=", value, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdIn(List<Integer> values) {
            addCriterion("fundfrom_id in", values, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdNotIn(List<Integer> values) {
            addCriterion("fundfrom_id not in", values, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdBetween(Integer value1, Integer value2) {
            addCriterion("fundfrom_id between", value1, value2, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andFundfromIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fundfrom_id not between", value1, value2, "fundfromId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdIsNull() {
            addCriterion("capital_source_id is null");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdIsNotNull() {
            addCriterion("capital_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdEqualTo(Integer value) {
            addCriterion("capital_source_id =", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdNotEqualTo(Integer value) {
            addCriterion("capital_source_id <>", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdGreaterThan(Integer value) {
            addCriterion("capital_source_id >", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("capital_source_id >=", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdLessThan(Integer value) {
            addCriterion("capital_source_id <", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("capital_source_id <=", value, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdIn(List<Integer> values) {
            addCriterion("capital_source_id in", values, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdNotIn(List<Integer> values) {
            addCriterion("capital_source_id not in", values, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("capital_source_id between", value1, value2, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCapitalSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("capital_source_id not between", value1, value2, "capitalSourceId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
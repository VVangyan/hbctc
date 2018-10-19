package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateMoneyRecordExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UpdateMoneyRecordExample() {
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

        public Criteria andOldMoneyIsNull() {
            addCriterion("old_money is null");
            return (Criteria) this;
        }

        public Criteria andOldMoneyIsNotNull() {
            addCriterion("old_money is not null");
            return (Criteria) this;
        }

        public Criteria andOldMoneyEqualTo(Double value) {
            addCriterion("old_money =", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotEqualTo(Double value) {
            addCriterion("old_money <>", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyGreaterThan(Double value) {
            addCriterion("old_money >", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("old_money >=", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyLessThan(Double value) {
            addCriterion("old_money <", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyLessThanOrEqualTo(Double value) {
            addCriterion("old_money <=", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyIn(List<Double> values) {
            addCriterion("old_money in", values, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotIn(List<Double> values) {
            addCriterion("old_money not in", values, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyBetween(Double value1, Double value2) {
            addCriterion("old_money between", value1, value2, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotBetween(Double value1, Double value2) {
            addCriterion("old_money not between", value1, value2, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIsNull() {
            addCriterion("new_money is null");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIsNotNull() {
            addCriterion("new_money is not null");
            return (Criteria) this;
        }

        public Criteria andNewMoneyEqualTo(Double value) {
            addCriterion("new_money =", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotEqualTo(Double value) {
            addCriterion("new_money <>", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyGreaterThan(Double value) {
            addCriterion("new_money >", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("new_money >=", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyLessThan(Double value) {
            addCriterion("new_money <", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyLessThanOrEqualTo(Double value) {
            addCriterion("new_money <=", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIn(List<Double> values) {
            addCriterion("new_money in", values, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotIn(List<Double> values) {
            addCriterion("new_money not in", values, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyBetween(Double value1, Double value2) {
            addCriterion("new_money between", value1, value2, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotBetween(Double value1, Double value2) {
            addCriterion("new_money not between", value1, value2, "newMoney");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
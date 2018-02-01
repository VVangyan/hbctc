package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectRequestFormExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public ProjectRequestFormExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(String value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(String value) {
            addCriterion("dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(String value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(String value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(String value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(String value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLike(String value) {
            addCriterion("dept like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotLike(String value) {
            addCriterion("dept not like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<String> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<String> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(String value1, String value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(String value1, String value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptpeoIsNull() {
            addCriterion("deptPeo is null");
            return (Criteria) this;
        }

        public Criteria andDeptpeoIsNotNull() {
            addCriterion("deptPeo is not null");
            return (Criteria) this;
        }

        public Criteria andDeptpeoEqualTo(String value) {
            addCriterion("deptPeo =", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoNotEqualTo(String value) {
            addCriterion("deptPeo <>", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoGreaterThan(String value) {
            addCriterion("deptPeo >", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoGreaterThanOrEqualTo(String value) {
            addCriterion("deptPeo >=", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoLessThan(String value) {
            addCriterion("deptPeo <", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoLessThanOrEqualTo(String value) {
            addCriterion("deptPeo <=", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoLike(String value) {
            addCriterion("deptPeo like", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoNotLike(String value) {
            addCriterion("deptPeo not like", value, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoIn(List<String> values) {
            addCriterion("deptPeo in", values, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoNotIn(List<String> values) {
            addCriterion("deptPeo not in", values, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoBetween(String value1, String value2) {
            addCriterion("deptPeo between", value1, value2, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoNotBetween(String value1, String value2) {
            addCriterion("deptPeo not between", value1, value2, "deptpeo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoIsNull() {
            addCriterion("deptPeoInfo is null");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoIsNotNull() {
            addCriterion("deptPeoInfo is not null");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoEqualTo(String value) {
            addCriterion("deptPeoInfo =", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoNotEqualTo(String value) {
            addCriterion("deptPeoInfo <>", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoGreaterThan(String value) {
            addCriterion("deptPeoInfo >", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoGreaterThanOrEqualTo(String value) {
            addCriterion("deptPeoInfo >=", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoLessThan(String value) {
            addCriterion("deptPeoInfo <", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoLessThanOrEqualTo(String value) {
            addCriterion("deptPeoInfo <=", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoLike(String value) {
            addCriterion("deptPeoInfo like", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoNotLike(String value) {
            addCriterion("deptPeoInfo not like", value, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoIn(List<String> values) {
            addCriterion("deptPeoInfo in", values, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoNotIn(List<String> values) {
            addCriterion("deptPeoInfo not in", values, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoBetween(String value1, String value2) {
            addCriterion("deptPeoInfo between", value1, value2, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andDeptpeoinfoNotBetween(String value1, String value2) {
            addCriterion("deptPeoInfo not between", value1, value2, "deptpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNull() {
            addCriterion("projectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectName =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectName <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectName >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectName >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectName <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectName <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectName like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectName not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectName in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectName not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectName between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectName not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectcontactIsNull() {
            addCriterion("projectContact is null");
            return (Criteria) this;
        }

        public Criteria andProjectcontactIsNotNull() {
            addCriterion("projectContact is not null");
            return (Criteria) this;
        }

        public Criteria andProjectcontactEqualTo(String value) {
            addCriterion("projectContact =", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactNotEqualTo(String value) {
            addCriterion("projectContact <>", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactGreaterThan(String value) {
            addCriterion("projectContact >", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactGreaterThanOrEqualTo(String value) {
            addCriterion("projectContact >=", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactLessThan(String value) {
            addCriterion("projectContact <", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactLessThanOrEqualTo(String value) {
            addCriterion("projectContact <=", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactLike(String value) {
            addCriterion("projectContact like", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactNotLike(String value) {
            addCriterion("projectContact not like", value, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactIn(List<String> values) {
            addCriterion("projectContact in", values, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactNotIn(List<String> values) {
            addCriterion("projectContact not in", values, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactBetween(String value1, String value2) {
            addCriterion("projectContact between", value1, value2, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectcontactNotBetween(String value1, String value2) {
            addCriterion("projectContact not between", value1, value2, "projectcontact");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoIsNull() {
            addCriterion("projectPeoInfo is null");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoIsNotNull() {
            addCriterion("projectPeoInfo is not null");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoEqualTo(String value) {
            addCriterion("projectPeoInfo =", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoNotEqualTo(String value) {
            addCriterion("projectPeoInfo <>", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoGreaterThan(String value) {
            addCriterion("projectPeoInfo >", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoGreaterThanOrEqualTo(String value) {
            addCriterion("projectPeoInfo >=", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoLessThan(String value) {
            addCriterion("projectPeoInfo <", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoLessThanOrEqualTo(String value) {
            addCriterion("projectPeoInfo <=", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoLike(String value) {
            addCriterion("projectPeoInfo like", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoNotLike(String value) {
            addCriterion("projectPeoInfo not like", value, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoIn(List<String> values) {
            addCriterion("projectPeoInfo in", values, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoNotIn(List<String> values) {
            addCriterion("projectPeoInfo not in", values, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoBetween(String value1, String value2) {
            addCriterion("projectPeoInfo between", value1, value2, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andProjectpeoinfoNotBetween(String value1, String value2) {
            addCriterion("projectPeoInfo not between", value1, value2, "projectpeoinfo");
            return (Criteria) this;
        }

        public Criteria andBuywayIsNull() {
            addCriterion("buyWay is null");
            return (Criteria) this;
        }

        public Criteria andBuywayIsNotNull() {
            addCriterion("buyWay is not null");
            return (Criteria) this;
        }

        public Criteria andBuywayEqualTo(String value) {
            addCriterion("buyWay =", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotEqualTo(String value) {
            addCriterion("buyWay <>", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayGreaterThan(String value) {
            addCriterion("buyWay >", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayGreaterThanOrEqualTo(String value) {
            addCriterion("buyWay >=", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLessThan(String value) {
            addCriterion("buyWay <", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLessThanOrEqualTo(String value) {
            addCriterion("buyWay <=", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLike(String value) {
            addCriterion("buyWay like", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotLike(String value) {
            addCriterion("buyWay not like", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayIn(List<String> values) {
            addCriterion("buyWay in", values, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotIn(List<String> values) {
            addCriterion("buyWay not in", values, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayBetween(String value1, String value2) {
            addCriterion("buyWay between", value1, value2, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotBetween(String value1, String value2) {
            addCriterion("buyWay not between", value1, value2, "buyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayIsNull() {
            addCriterion("moneyWay is null");
            return (Criteria) this;
        }

        public Criteria andMoneywayIsNotNull() {
            addCriterion("moneyWay is not null");
            return (Criteria) this;
        }

        public Criteria andMoneywayEqualTo(String value) {
            addCriterion("moneyWay =", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayNotEqualTo(String value) {
            addCriterion("moneyWay <>", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayGreaterThan(String value) {
            addCriterion("moneyWay >", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayGreaterThanOrEqualTo(String value) {
            addCriterion("moneyWay >=", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayLessThan(String value) {
            addCriterion("moneyWay <", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayLessThanOrEqualTo(String value) {
            addCriterion("moneyWay <=", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayLike(String value) {
            addCriterion("moneyWay like", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayNotLike(String value) {
            addCriterion("moneyWay not like", value, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayIn(List<String> values) {
            addCriterion("moneyWay in", values, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayNotIn(List<String> values) {
            addCriterion("moneyWay not in", values, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayBetween(String value1, String value2) {
            addCriterion("moneyWay between", value1, value2, "moneyway");
            return (Criteria) this;
        }

        public Criteria andMoneywayNotBetween(String value1, String value2) {
            addCriterion("moneyWay not between", value1, value2, "moneyway");
            return (Criteria) this;
        }

        public Criteria andPremoneyIsNull() {
            addCriterion("preMoney is null");
            return (Criteria) this;
        }

        public Criteria andPremoneyIsNotNull() {
            addCriterion("preMoney is not null");
            return (Criteria) this;
        }

        public Criteria andPremoneyEqualTo(Double value) {
            addCriterion("preMoney =", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyNotEqualTo(Double value) {
            addCriterion("preMoney <>", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyGreaterThan(Double value) {
            addCriterion("preMoney >", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("preMoney >=", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyLessThan(Double value) {
            addCriterion("preMoney <", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyLessThanOrEqualTo(Double value) {
            addCriterion("preMoney <=", value, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyIn(List<Double> values) {
            addCriterion("preMoney in", values, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyNotIn(List<Double> values) {
            addCriterion("preMoney not in", values, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyBetween(Double value1, Double value2) {
            addCriterion("preMoney between", value1, value2, "premoney");
            return (Criteria) this;
        }

        public Criteria andPremoneyNotBetween(Double value1, Double value2) {
            addCriterion("preMoney not between", value1, value2, "premoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyIsNull() {
            addCriterion("questMoney is null");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyIsNotNull() {
            addCriterion("questMoney is not null");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyEqualTo(Double value) {
            addCriterion("questMoney =", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyNotEqualTo(Double value) {
            addCriterion("questMoney <>", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyGreaterThan(Double value) {
            addCriterion("questMoney >", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("questMoney >=", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyLessThan(Double value) {
            addCriterion("questMoney <", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyLessThanOrEqualTo(Double value) {
            addCriterion("questMoney <=", value, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyIn(List<Double> values) {
            addCriterion("questMoney in", values, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyNotIn(List<Double> values) {
            addCriterion("questMoney not in", values, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyBetween(Double value1, Double value2) {
            addCriterion("questMoney between", value1, value2, "questmoney");
            return (Criteria) this;
        }

        public Criteria andQuestmoneyNotBetween(Double value1, Double value2) {
            addCriterion("questMoney not between", value1, value2, "questmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(Double value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(Double value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(Double value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(Double value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(Double value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<Double> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<Double> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(Double value1, Double value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(Double value1, Double value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andOthersIsNull() {
            addCriterion("others is null");
            return (Criteria) this;
        }

        public Criteria andOthersIsNotNull() {
            addCriterion("others is not null");
            return (Criteria) this;
        }

        public Criteria andOthersEqualTo(String value) {
            addCriterion("others =", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotEqualTo(String value) {
            addCriterion("others <>", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersGreaterThan(String value) {
            addCriterion("others >", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersGreaterThanOrEqualTo(String value) {
            addCriterion("others >=", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLessThan(String value) {
            addCriterion("others <", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLessThanOrEqualTo(String value) {
            addCriterion("others <=", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersLike(String value) {
            addCriterion("others like", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotLike(String value) {
            addCriterion("others not like", value, "others");
            return (Criteria) this;
        }

        public Criteria andOthersIn(List<String> values) {
            addCriterion("others in", values, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotIn(List<String> values) {
            addCriterion("others not in", values, "others");
            return (Criteria) this;
        }

        public Criteria andOthersBetween(String value1, String value2) {
            addCriterion("others between", value1, value2, "others");
            return (Criteria) this;
        }

        public Criteria andOthersNotBetween(String value1, String value2) {
            addCriterion("others not between", value1, value2, "others");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterionForJDBCDate("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterionForJDBCDate("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andStepstatusIsNull() {
            addCriterion("stepStatus is null");
            return (Criteria) this;
        }

        public Criteria andStepstatusIsNotNull() {
            addCriterion("stepStatus is not null");
            return (Criteria) this;
        }

        public Criteria andStepstatusEqualTo(Integer value) {
            addCriterion("stepStatus =", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusNotEqualTo(Integer value) {
            addCriterion("stepStatus <>", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusGreaterThan(Integer value) {
            addCriterion("stepStatus >", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stepStatus >=", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusLessThan(Integer value) {
            addCriterion("stepStatus <", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusLessThanOrEqualTo(Integer value) {
            addCriterion("stepStatus <=", value, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusIn(List<Integer> values) {
            addCriterion("stepStatus in", values, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusNotIn(List<Integer> values) {
            addCriterion("stepStatus not in", values, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusBetween(Integer value1, Integer value2) {
            addCriterion("stepStatus between", value1, value2, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andStepstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stepStatus not between", value1, value2, "stepstatus");
            return (Criteria) this;
        }

        public Criteria andIstenIsNull() {
            addCriterion("isTen is null");
            return (Criteria) this;
        }

        public Criteria andIstenIsNotNull() {
            addCriterion("isTen is not null");
            return (Criteria) this;
        }

        public Criteria andIstenEqualTo(Integer value) {
            addCriterion("isTen =", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenNotEqualTo(Integer value) {
            addCriterion("isTen <>", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenGreaterThan(Integer value) {
            addCriterion("isTen >", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenGreaterThanOrEqualTo(Integer value) {
            addCriterion("isTen >=", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenLessThan(Integer value) {
            addCriterion("isTen <", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenLessThanOrEqualTo(Integer value) {
            addCriterion("isTen <=", value, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenIn(List<Integer> values) {
            addCriterion("isTen in", values, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenNotIn(List<Integer> values) {
            addCriterion("isTen not in", values, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenBetween(Integer value1, Integer value2) {
            addCriterion("isTen between", value1, value2, "isten");
            return (Criteria) this;
        }

        public Criteria andIstenNotBetween(Integer value1, Integer value2) {
            addCriterion("isTen not between", value1, value2, "isten");
            return (Criteria) this;
        }

        public Criteria andBh1IsNull() {
            addCriterion("bh1 is null");
            return (Criteria) this;
        }

        public Criteria andBh1IsNotNull() {
            addCriterion("bh1 is not null");
            return (Criteria) this;
        }

        public Criteria andBh1EqualTo(Integer value) {
            addCriterion("bh1 =", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1NotEqualTo(Integer value) {
            addCriterion("bh1 <>", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1GreaterThan(Integer value) {
            addCriterion("bh1 >", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1GreaterThanOrEqualTo(Integer value) {
            addCriterion("bh1 >=", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1LessThan(Integer value) {
            addCriterion("bh1 <", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1LessThanOrEqualTo(Integer value) {
            addCriterion("bh1 <=", value, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1In(List<Integer> values) {
            addCriterion("bh1 in", values, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1NotIn(List<Integer> values) {
            addCriterion("bh1 not in", values, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1Between(Integer value1, Integer value2) {
            addCriterion("bh1 between", value1, value2, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh1NotBetween(Integer value1, Integer value2) {
            addCriterion("bh1 not between", value1, value2, "bh1");
            return (Criteria) this;
        }

        public Criteria andBh2IsNull() {
            addCriterion("bh2 is null");
            return (Criteria) this;
        }

        public Criteria andBh2IsNotNull() {
            addCriterion("bh2 is not null");
            return (Criteria) this;
        }

        public Criteria andBh2EqualTo(Integer value) {
            addCriterion("bh2 =", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2NotEqualTo(Integer value) {
            addCriterion("bh2 <>", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2GreaterThan(Integer value) {
            addCriterion("bh2 >", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2GreaterThanOrEqualTo(Integer value) {
            addCriterion("bh2 >=", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2LessThan(Integer value) {
            addCriterion("bh2 <", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2LessThanOrEqualTo(Integer value) {
            addCriterion("bh2 <=", value, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2In(List<Integer> values) {
            addCriterion("bh2 in", values, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2NotIn(List<Integer> values) {
            addCriterion("bh2 not in", values, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2Between(Integer value1, Integer value2) {
            addCriterion("bh2 between", value1, value2, "bh2");
            return (Criteria) this;
        }

        public Criteria andBh2NotBetween(Integer value1, Integer value2) {
            addCriterion("bh2 not between", value1, value2, "bh2");
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
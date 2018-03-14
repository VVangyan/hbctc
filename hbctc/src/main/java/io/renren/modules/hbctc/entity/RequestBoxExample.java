package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestBoxExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public RequestBoxExample() {
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

        public Criteria andFromidIsNull() {
            addCriterion("fromid is null");
            return (Criteria) this;
        }

        public Criteria andFromidIsNotNull() {
            addCriterion("fromid is not null");
            return (Criteria) this;
        }

        public Criteria andFromidEqualTo(Integer value) {
            addCriterion("fromid =", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotEqualTo(Integer value) {
            addCriterion("fromid <>", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThan(Integer value) {
            addCriterion("fromid >", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromid >=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThan(Integer value) {
            addCriterion("fromid <", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThanOrEqualTo(Integer value) {
            addCriterion("fromid <=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidIn(List<Integer> values) {
            addCriterion("fromid in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotIn(List<Integer> values) {
            addCriterion("fromid not in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidBetween(Integer value1, Integer value2) {
            addCriterion("fromid between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotBetween(Integer value1, Integer value2) {
            addCriterion("fromid not between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromuseridIsNull() {
            addCriterion("fromuserid is null");
            return (Criteria) this;
        }

        public Criteria andFromuseridIsNotNull() {
            addCriterion("fromuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFromuseridEqualTo(Integer value) {
            addCriterion("fromuserid =", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotEqualTo(Integer value) {
            addCriterion("fromuserid <>", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridGreaterThan(Integer value) {
            addCriterion("fromuserid >", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromuserid >=", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridLessThan(Integer value) {
            addCriterion("fromuserid <", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridLessThanOrEqualTo(Integer value) {
            addCriterion("fromuserid <=", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridIn(List<Integer> values) {
            addCriterion("fromuserid in", values, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotIn(List<Integer> values) {
            addCriterion("fromuserid not in", values, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridBetween(Integer value1, Integer value2) {
            addCriterion("fromuserid between", value1, value2, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fromuserid not between", value1, value2, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromusernameIsNull() {
            addCriterion("fromusername is null");
            return (Criteria) this;
        }

        public Criteria andFromusernameIsNotNull() {
            addCriterion("fromusername is not null");
            return (Criteria) this;
        }

        public Criteria andFromusernameEqualTo(String value) {
            addCriterion("fromusername =", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotEqualTo(String value) {
            addCriterion("fromusername <>", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameGreaterThan(String value) {
            addCriterion("fromusername >", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameGreaterThanOrEqualTo(String value) {
            addCriterion("fromusername >=", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLessThan(String value) {
            addCriterion("fromusername <", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLessThanOrEqualTo(String value) {
            addCriterion("fromusername <=", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLike(String value) {
            addCriterion("fromusername like", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotLike(String value) {
            addCriterion("fromusername not like", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameIn(List<String> values) {
            addCriterion("fromusername in", values, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotIn(List<String> values) {
            addCriterion("fromusername not in", values, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameBetween(String value1, String value2) {
            addCriterion("fromusername between", value1, value2, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotBetween(String value1, String value2) {
            addCriterion("fromusername not between", value1, value2, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromroleidIsNull() {
            addCriterion("fromroleid is null");
            return (Criteria) this;
        }

        public Criteria andFromroleidIsNotNull() {
            addCriterion("fromroleid is not null");
            return (Criteria) this;
        }

        public Criteria andFromroleidEqualTo(Integer value) {
            addCriterion("fromroleid =", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidNotEqualTo(Integer value) {
            addCriterion("fromroleid <>", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidGreaterThan(Integer value) {
            addCriterion("fromroleid >", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromroleid >=", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidLessThan(Integer value) {
            addCriterion("fromroleid <", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidLessThanOrEqualTo(Integer value) {
            addCriterion("fromroleid <=", value, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidIn(List<Integer> values) {
            addCriterion("fromroleid in", values, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidNotIn(List<Integer> values) {
            addCriterion("fromroleid not in", values, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidBetween(Integer value1, Integer value2) {
            addCriterion("fromroleid between", value1, value2, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromroleidNotBetween(Integer value1, Integer value2) {
            addCriterion("fromroleid not between", value1, value2, "fromroleid");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoIsNull() {
            addCriterion("fromdeptno is null");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoIsNotNull() {
            addCriterion("fromdeptno is not null");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoEqualTo(String value) {
            addCriterion("fromdeptno =", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoNotEqualTo(String value) {
            addCriterion("fromdeptno <>", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoGreaterThan(String value) {
            addCriterion("fromdeptno >", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoGreaterThanOrEqualTo(String value) {
            addCriterion("fromdeptno >=", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoLessThan(String value) {
            addCriterion("fromdeptno <", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoLessThanOrEqualTo(String value) {
            addCriterion("fromdeptno <=", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoLike(String value) {
            addCriterion("fromdeptno like", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoNotLike(String value) {
            addCriterion("fromdeptno not like", value, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoIn(List<String> values) {
            addCriterion("fromdeptno in", values, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoNotIn(List<String> values) {
            addCriterion("fromdeptno not in", values, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoBetween(String value1, String value2) {
            addCriterion("fromdeptno between", value1, value2, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnoNotBetween(String value1, String value2) {
            addCriterion("fromdeptno not between", value1, value2, "fromdeptno");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameIsNull() {
            addCriterion("fromdeptname is null");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameIsNotNull() {
            addCriterion("fromdeptname is not null");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameEqualTo(String value) {
            addCriterion("fromdeptname =", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameNotEqualTo(String value) {
            addCriterion("fromdeptname <>", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameGreaterThan(String value) {
            addCriterion("fromdeptname >", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("fromdeptname >=", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameLessThan(String value) {
            addCriterion("fromdeptname <", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameLessThanOrEqualTo(String value) {
            addCriterion("fromdeptname <=", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameLike(String value) {
            addCriterion("fromdeptname like", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameNotLike(String value) {
            addCriterion("fromdeptname not like", value, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameIn(List<String> values) {
            addCriterion("fromdeptname in", values, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameNotIn(List<String> values) {
            addCriterion("fromdeptname not in", values, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameBetween(String value1, String value2) {
            addCriterion("fromdeptname between", value1, value2, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdeptnameNotBetween(String value1, String value2) {
            addCriterion("fromdeptname not between", value1, value2, "fromdeptname");
            return (Criteria) this;
        }

        public Criteria andFromdateIsNull() {
            addCriterion("fromdate is null");
            return (Criteria) this;
        }

        public Criteria andFromdateIsNotNull() {
            addCriterion("fromdate is not null");
            return (Criteria) this;
        }

        public Criteria andFromdateEqualTo(Date value) {
            addCriterion("fromdate =", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateNotEqualTo(Date value) {
            addCriterion("fromdate <>", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateGreaterThan(Date value) {
            addCriterion("fromdate >", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fromdate >=", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateLessThan(Date value) {
            addCriterion("fromdate <", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateLessThanOrEqualTo(Date value) {
            addCriterion("fromdate <=", value, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateIn(List<Date> values) {
            addCriterion("fromdate in", values, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateNotIn(List<Date> values) {
            addCriterion("fromdate not in", values, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateBetween(Date value1, Date value2) {
            addCriterion("fromdate between", value1, value2, "fromdate");
            return (Criteria) this;
        }

        public Criteria andFromdateNotBetween(Date value1, Date value2) {
            addCriterion("fromdate not between", value1, value2, "fromdate");
            return (Criteria) this;
        }

        public Criteria andTouseridIsNull() {
            addCriterion("touserid is null");
            return (Criteria) this;
        }

        public Criteria andTouseridIsNotNull() {
            addCriterion("touserid is not null");
            return (Criteria) this;
        }

        public Criteria andTouseridEqualTo(Integer value) {
            addCriterion("touserid =", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotEqualTo(Integer value) {
            addCriterion("touserid <>", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridGreaterThan(Integer value) {
            addCriterion("touserid >", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("touserid >=", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridLessThan(Integer value) {
            addCriterion("touserid <", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridLessThanOrEqualTo(Integer value) {
            addCriterion("touserid <=", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridIn(List<Integer> values) {
            addCriterion("touserid in", values, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotIn(List<Integer> values) {
            addCriterion("touserid not in", values, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridBetween(Integer value1, Integer value2) {
            addCriterion("touserid between", value1, value2, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotBetween(Integer value1, Integer value2) {
            addCriterion("touserid not between", value1, value2, "touserid");
            return (Criteria) this;
        }

        public Criteria andTousernameIsNull() {
            addCriterion("tousername is null");
            return (Criteria) this;
        }

        public Criteria andTousernameIsNotNull() {
            addCriterion("tousername is not null");
            return (Criteria) this;
        }

        public Criteria andTousernameEqualTo(String value) {
            addCriterion("tousername =", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotEqualTo(String value) {
            addCriterion("tousername <>", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameGreaterThan(String value) {
            addCriterion("tousername >", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameGreaterThanOrEqualTo(String value) {
            addCriterion("tousername >=", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLessThan(String value) {
            addCriterion("tousername <", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLessThanOrEqualTo(String value) {
            addCriterion("tousername <=", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLike(String value) {
            addCriterion("tousername like", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotLike(String value) {
            addCriterion("tousername not like", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameIn(List<String> values) {
            addCriterion("tousername in", values, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotIn(List<String> values) {
            addCriterion("tousername not in", values, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameBetween(String value1, String value2) {
            addCriterion("tousername between", value1, value2, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotBetween(String value1, String value2) {
            addCriterion("tousername not between", value1, value2, "tousername");
            return (Criteria) this;
        }

        public Criteria andToroleidIsNull() {
            addCriterion("toroleid is null");
            return (Criteria) this;
        }

        public Criteria andToroleidIsNotNull() {
            addCriterion("toroleid is not null");
            return (Criteria) this;
        }

        public Criteria andToroleidEqualTo(Integer value) {
            addCriterion("toroleid =", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidNotEqualTo(Integer value) {
            addCriterion("toroleid <>", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidGreaterThan(Integer value) {
            addCriterion("toroleid >", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("toroleid >=", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidLessThan(Integer value) {
            addCriterion("toroleid <", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidLessThanOrEqualTo(Integer value) {
            addCriterion("toroleid <=", value, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidIn(List<Integer> values) {
            addCriterion("toroleid in", values, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidNotIn(List<Integer> values) {
            addCriterion("toroleid not in", values, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidBetween(Integer value1, Integer value2) {
            addCriterion("toroleid between", value1, value2, "toroleid");
            return (Criteria) this;
        }

        public Criteria andToroleidNotBetween(Integer value1, Integer value2) {
            addCriterion("toroleid not between", value1, value2, "toroleid");
            return (Criteria) this;
        }

        public Criteria andTodeptnoIsNull() {
            addCriterion("todeptno is null");
            return (Criteria) this;
        }

        public Criteria andTodeptnoIsNotNull() {
            addCriterion("todeptno is not null");
            return (Criteria) this;
        }

        public Criteria andTodeptnoEqualTo(String value) {
            addCriterion("todeptno =", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoNotEqualTo(String value) {
            addCriterion("todeptno <>", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoGreaterThan(String value) {
            addCriterion("todeptno >", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoGreaterThanOrEqualTo(String value) {
            addCriterion("todeptno >=", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoLessThan(String value) {
            addCriterion("todeptno <", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoLessThanOrEqualTo(String value) {
            addCriterion("todeptno <=", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoLike(String value) {
            addCriterion("todeptno like", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoNotLike(String value) {
            addCriterion("todeptno not like", value, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoIn(List<String> values) {
            addCriterion("todeptno in", values, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoNotIn(List<String> values) {
            addCriterion("todeptno not in", values, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoBetween(String value1, String value2) {
            addCriterion("todeptno between", value1, value2, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnoNotBetween(String value1, String value2) {
            addCriterion("todeptno not between", value1, value2, "todeptno");
            return (Criteria) this;
        }

        public Criteria andTodeptnameIsNull() {
            addCriterion("todeptname is null");
            return (Criteria) this;
        }

        public Criteria andTodeptnameIsNotNull() {
            addCriterion("todeptname is not null");
            return (Criteria) this;
        }

        public Criteria andTodeptnameEqualTo(String value) {
            addCriterion("todeptname =", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameNotEqualTo(String value) {
            addCriterion("todeptname <>", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameGreaterThan(String value) {
            addCriterion("todeptname >", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("todeptname >=", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameLessThan(String value) {
            addCriterion("todeptname <", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameLessThanOrEqualTo(String value) {
            addCriterion("todeptname <=", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameLike(String value) {
            addCriterion("todeptname like", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameNotLike(String value) {
            addCriterion("todeptname not like", value, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameIn(List<String> values) {
            addCriterion("todeptname in", values, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameNotIn(List<String> values) {
            addCriterion("todeptname not in", values, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameBetween(String value1, String value2) {
            addCriterion("todeptname between", value1, value2, "todeptname");
            return (Criteria) this;
        }

        public Criteria andTodeptnameNotBetween(String value1, String value2) {
            addCriterion("todeptname not between", value1, value2, "todeptname");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNull() {
            addCriterion("checkstatus is null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNotNull() {
            addCriterion("checkstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusEqualTo(Integer value) {
            addCriterion("checkstatus =", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotEqualTo(Integer value) {
            addCriterion("checkstatus <>", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThan(Integer value) {
            addCriterion("checkstatus >", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkstatus >=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThan(Integer value) {
            addCriterion("checkstatus <", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThanOrEqualTo(Integer value) {
            addCriterion("checkstatus <=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIn(List<Integer> values) {
            addCriterion("checkstatus in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotIn(List<Integer> values) {
            addCriterion("checkstatus not in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusBetween(Integer value1, Integer value2) {
            addCriterion("checkstatus between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("checkstatus not between", value1, value2, "checkstatus");
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
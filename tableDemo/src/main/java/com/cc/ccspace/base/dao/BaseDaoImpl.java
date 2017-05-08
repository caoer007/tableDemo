package com.cc.ccspace.base.dao;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {

    /**
     */

    public <T> T selectOne(NameSpace nameSpace, String sqlId) {
        return super.getSqlSession().<T>selectOne(getStatement(nameSpace, sqlId));
    }

    /**
     */
    public <T> T selectOne(NameSpace nameSpace, String sqlId, Object parameter) {
        return super.getSqlSession().<T>selectOne(getStatement(nameSpace, sqlId), parameter);
    }

    /**
     */
    public <E> List<E> selectList(NameSpace nameSpace, String sqlId) {
        return super.getSqlSession().selectList(getStatement(nameSpace, sqlId));
    }

    /**
     */
    @Override
    public <E> List<E> selectList(NameSpace nameSpace, String sqlId, Object parameter) {
        return super.getSqlSession().selectList(getStatement(nameSpace, sqlId), parameter);
    }

    /**
     */
    public <E> List<E> selectList(NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds) {
        return super.getSqlSession().selectList(getStatement(nameSpace, sqlId), parameter, rowBounds);
    }

    /**
     */
    public <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, String mapKey) {
        return super.getSqlSession().selectMap(getStatement(nameSpace, sqlId), mapKey);
    }

    /**
     */
    public <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, Object parameter, String mapKey) {
        return super.getSqlSession().selectMap(getStatement(nameSpace, sqlId), parameter, mapKey);
    }

    /**
     */
    public <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, Object parameter, String mapKey, RowBounds rowBounds) {
        return super.getSqlSession().selectMap(getStatement(nameSpace, sqlId), parameter, mapKey, rowBounds);
    }

    /**
     */
    public void select(NameSpace nameSpace, String sqlId, Object parameter, ResultHandler handler) {
        super.getSqlSession().select(getStatement(nameSpace, sqlId), parameter, handler);
    }

    /**
     */
    public void select(NameSpace nameSpace, String sqlId, ResultHandler handler) {
        super.getSqlSession().select(getStatement(nameSpace, sqlId), handler);
    }

    /**
     */
    public void select(NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        super.getSqlSession().select(getStatement(nameSpace, sqlId), parameter, rowBounds, handler);
    }

    public int insert(NameSpace nameSpace, String sqlId) throws Exception {
        return super.getSqlSession().insert(getStatement(nameSpace, sqlId));
    }

    public int insert(NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return super.getSqlSession().insert(getStatement(nameSpace, sqlId), parameter);
    }

    public int update(NameSpace nameSpace, String sqlId) throws Exception {
        return super.getSqlSession().update(getStatement(nameSpace, sqlId));
    }


    public int update(NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return super.getSqlSession().update(getStatement(nameSpace, sqlId), parameter);
    }

    public int delete(NameSpace nameSpace, String sqlId) throws Exception {
        return super.getSqlSession().delete(getStatement(nameSpace, sqlId));
    }

    public int delete(NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return super.getSqlSession().delete(getStatement(nameSpace, sqlId), parameter);
    }

    public <T> T selectOne(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId) {
        return null;
    }

    public <T> T selectOne(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter) {
        return null;
    }

    public <E> List<E> selectList(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId) {
        return null;
    }

    public <E> List<E> selectList(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter) {
        return null;
    }

    public <E> List<E> selectList(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds) {
        return null;
    }

    public <K, V> Map<K, V> selectMap(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, String mapKey) {
        return null;
    }

    public <K, V> Map<K, V> selectMap(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter, String mapKey) {
        return null;
    }

    public <K, V> Map<K, V> selectMap(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter, String mapKey, RowBounds rowBounds) {
        return null;
    }

    public void select(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter, ResultHandler handler) {

    }

    public void select(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, ResultHandler handler) {

    }

    public void select(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds, ResultHandler handler) {

    }

    public int insert(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId) throws Exception {
        return 0;
    }

    public int insert(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return 0;
    }

    public int update(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId) throws Exception {
        return 0;
    }

    public int update(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return 0;
    }

    public int delete(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId) throws Exception {
        return 0;
    }

    public int delete(com.sun.org.apache.xml.internal.utils.NameSpace nameSpace, String sqlId, Object parameter) throws Exception {
        return 0;
    }

    /**
     */
    @Override
    public void commit() {
        super.getSqlSession().commit();
    }

    /**
     */
    @Override
    public void commit(boolean force) {
        super.getSqlSession().commit(force);
    }

    /**
     */
    @Override
    public void rollback() {
        super.getSqlSession().rollback();
    }

    /**
     */
    @Override
    public void rollback(boolean force) {
        super.getSqlSession().rollback(force);
    }

    /**
     */
    @Override
    public List<BatchResult> flushStatements() {
        return super.getSqlSession().flushStatements();
    }

    /**
     */
    @Override
    public void close() {
        super.getSqlSession().close();
    }

    /**
     */
    @Override
    public void clearCache() {
        super.getSqlSession().clearCache();
    }

    /**
     */
    @Override
    public Configuration getConfiguration() {
        return super.getSqlSession().getConfiguration();
    }

    /**
     */
    @Override
    public <T> T getMapper(Class<T> type) {
        return super.getSqlSession().getMapper(type);
    }

    /**
     */
    @Override
    public Connection getConnection() {
        return super.getSqlSession().getConnection();
    }

    private String getStatement(NameSpace nameSpace, String sqlId) {
        return nameSpace.getValue()+"."+sqlId;
    }

}

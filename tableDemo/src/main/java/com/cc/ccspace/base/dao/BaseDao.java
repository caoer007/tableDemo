package com.cc.ccspace.base.dao;


import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface BaseDao {




    /**
     * Retrieve a single row mapped from the statement key

     * @return Mapped object
     */
    <T> T selectOne(NameSpace nameSpace, String sqlId);

    /**
     * Retrieve a single row mapped from the statement key and parameter.

     * @return Mapped object
     */
    <T> T selectOne(NameSpace nameSpace, String sqlId, Object parameter);

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.

     * @return List of mapped object
     */
    <E> List<E> selectList(NameSpace nameSpace, String sqlId);

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.

     * @return List of mapped object
     */
    <E> List<E> selectList(NameSpace nameSpace, String sqlId, Object parameter);

    /**
     * Retrieve a list of mapped objects from the statement key and parameter,
     * within the specified row bounds.

     * @return List of mapped object
     */
    <E> List<E> selectList(NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds);

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.
     * Eg. Return a of Map[Integer,Author] for selectMap("selectAuthors","id")
     * @return Map containing key pair data.
     */
    <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, String mapKey);

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.

     * @return Map containing key pair data.
     */
    <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, Object parameter, String mapKey);

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.

     * @return Map containing key pair data.
     */
    <K, V> Map<K, V> selectMap(NameSpace nameSpace, String sqlId, Object parameter, String mapKey, RowBounds rowBounds);

    /**
     * Retrieve a single row mapped from the statement key and parameter
     * using a {@code ResultHandler}.

     * @return Mapped object
     */
    void select(NameSpace nameSpace, String sqlId, Object parameter, ResultHandler handler);

    /**
     * Retrieve a single row mapped from the statement
     * using a {@code ResultHandler}.

     * @return Mapped object
     */
    void select(NameSpace nameSpace, String sqlId, ResultHandler handler);

    /**
     * Retrieve a single row mapped from the statement key and parameter
     * using a {@code ResultHandler} and {@code RowBounds}

     * @return Mapped object
     */
    void select(NameSpace nameSpace, String sqlId, Object parameter, RowBounds rowBounds, ResultHandler handler);

    /**
     * Execute an insert statement.

     * @return int The number of rows affected by the insert.
     */
    int insert(NameSpace nameSpace, String sqlId) throws Exception;

    /**
     * Execute an insert statement with the given parameter object. Any generated
     * autoincrement values or selectKey entries will modify the given parameter
     * object properties. Only the number of rows affected will be returned.

     * @return int The number of rows affected by the insert.
     */
    int insert(NameSpace nameSpace, String sqlId, Object parameter) throws Exception;

    /**
     * Execute an update statement. The number of rows affected will be returned.

     * @return int The number of rows affected by the update.
     */
    int update(NameSpace nameSpace, String sqlId) throws Exception;

    /**
     * Execute an update statement. The number of rows affected will be returned.

     * @return int The number of rows affected by the update.
     */
    int update(NameSpace nameSpace, String sqlId, Object parameter) throws Exception;

    /**
     * Execute a delete statement. The number of rows affected will be returned.

     * @return int The number of rows affected by the delete.
     */
    int delete(NameSpace nameSpace, String sqlId) throws Exception;

    /**
     * Execute a delete statement. The number of rows affected will be returned.

     * @return int The number of rows affected by the delete.
     */
    int delete(NameSpace nameSpace, String sqlId, Object parameter) throws Exception;

    /**
     * Flushes batch statements and commits database connection.
     * Note that database connection will not be committed if no updates/deletes/inserts were called.
     * To force the commit call {@link SqlSession#commit(boolean)}
     */
    void commit();

    /**
     * Flushes batch statements and commits database connection.
     * @param force forces connection commit
     */
    void commit(boolean force);

    /**
     * Discards pending batch statements and rolls database connection back.
     * Note that database connection will not be rolled back if no updates/deletes/inserts were called.
     * To force the rollback call {@link SqlSession#rollback(boolean)}
     */
    void rollback();

    /**
     * Discards pending batch statements and rolls database connection back.
     * Note that database connection will not be rolled back if no updates/deletes/inserts were called.
     * @param force forces connection rollback
     */
    void rollback(boolean force);

    /**
     * Flushes batch statements.
     * @return BatchResult list of updated records
     * @since 3.0.6
     */
    List<BatchResult> flushStatements();

    /**
     * Closes the session
     */
    void close();

    /**
     * Clears local session cache
     */
    void clearCache();

    /**
     * Retrieves current configuration
     * @return Configuration
     */
    Configuration getConfiguration();

    /**
     * Retrieves a mapper.
     * @param <T> the mapper type
     * @param type Mapper interface class
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);

    /**
     * Retrieves inner database connection
     * @return Connection
     */
    Connection getConnection();

}

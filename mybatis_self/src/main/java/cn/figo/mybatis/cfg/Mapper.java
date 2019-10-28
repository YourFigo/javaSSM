package cn.figo.mybatis.cfg;

/**
 * @Author Figo
 * @Date 2019/10/28 22:01
 * 用于封装执行的SQL语句和结果类型的全限定类名
 */
public class Mapper {
    //SQL
    private String queryString;
    //实体类的全限定类名
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}

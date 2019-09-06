package org.zeason.corgi.dto;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/6 12:15
 */
public class MetaDataDTO {
    String column_name;
    String data_type;
    String column_comment;

    public String getColumn_name() {
        return column_name;
    }

    public MetaDataDTO setColumn_name(String column_name) {
        this.column_name = column_name;
        return this;
    }

    public String getData_type() {
        return data_type;
    }

    public MetaDataDTO setData_type(String data_type) {
        this.data_type = data_type;
        return this;
    }

    public String getColumn_comment() {
        return column_comment;
    }

    public MetaDataDTO setColumn_comment(String column_comment) {
        this.column_comment = column_comment;
        return this;
    }

    @Override
    public String toString() {
        return "MetaDataDTO{" +
                "column_name='" + column_name + '\'' +
                ", data_type='" + data_type + '\'' +
                ", column_comment='" + column_comment + '\'' +
                '}';
    }
}

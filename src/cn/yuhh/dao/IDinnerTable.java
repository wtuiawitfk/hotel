package cn.yuhh.dao;

import cn.yuhh.entity.DinnerTable;

import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public interface IDinnerTable {

    void add(DinnerTable dinnerTable);

    void delete(int id);

    void updata(DinnerTable dinnerTable);

    List<DinnerTable> query();

    DinnerTable findById(int id);

    List<DinnerTable> query(String keyword);

    void quitTable(int id);
}

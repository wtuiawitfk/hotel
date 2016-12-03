package cn.yuhh.service.impl;

import cn.yuhh.dao.IDinnerTableDao;
import cn.yuhh.entity.DinnerTable;
import cn.yuhh.factory.BeanFactory;
import cn.yuhh.service.IDinnerTableService;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by Brill on 2016/12/3.
 */
public class DinnerTableService implements IDinnerTableService {

    IDinnerTableDao dao = BeanFactory.getInstance("DinnerTableDao", IDinnerTableDao.class);
    @Override
    public void add(DinnerTable dinnerTable) {
        dao.add(dinnerTable);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void updata(DinnerTable dinnerTable) {
        dao.updata(dinnerTable);
    }

    @Override
    public List<DinnerTable> query() {
        return dao.query();
    }

    @Override
    public DinnerTable findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<DinnerTable> query(String keyword) {
        return dao.query(keyword);
    }

    @Override
    public void quitTable(int id) {
        dao.quitTable(id);
    }

    @Override
    public DinnerTable changeState(int id) {
        DinnerTable table = dao.findById(id);
        int status = table.getTableStatus();

        if (status == 0) {
            status=1;
            Date data = new Date();
            table.setOrderDate(data);
        } else if (status == 1) {
            status = 0;
            table.setOrderDate(null);
        }
        table.setTableStatus(status);
        dao.updata(table);
        return table;
    }
}

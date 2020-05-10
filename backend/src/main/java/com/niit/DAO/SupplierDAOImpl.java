package com.niit.DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO {
@Autowired
SessionFactory sessionFactory;

public boolean addSupplier(Supplier supplier) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().save(supplier);
return true;
}
catch(Exception e) {
return false;
}
}
public boolean deleteSupplier(Supplier supplier) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().delete(supplier);
return true;
}
catch(Exception e) {
return false;
}
}

public boolean updateSupplier(Supplier supplier) {
// TODO Auto-generated method stub
try {
sessionFactory.getCurrentSession().update(supplier);
return true;
}
catch(Exception e) {
return false;
}
}

public List<Supplier> listSuppliers() {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Query query=session.createQuery("from Supplier");
List<Supplier> listSuppliers=query.list();
session.close();
return listSuppliers;
}

public Supplier getSupplier(int SupplierId) {
// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
Supplier supplier=(Supplier)session.get(Supplier.class,SupplierId);
session.close();
return supplier;
}


}

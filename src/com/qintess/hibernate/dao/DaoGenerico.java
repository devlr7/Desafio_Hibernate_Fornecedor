package com.qintess.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.hibernate.config.HibernateConfig;
import com.qintess.hibernate.estudo.desafio.fornecedor.Fornecedor;
import com.qintess.hibernate.estudo.desafio.fornecedor.InterfaceModel;

public class DaoGenerico<T extends InterfaceModel> {

	public void salvar(T obj) {
		
		Transaction transacao = null;
		
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			transacao = session.beginTransaction();
		
			session.save(obj);

			transacao.commit();
			
			session.close();
			
		} catch (Exception e) {
			
			if (transacao != null) {
				
				transacao.rollback();
			}
			
			e.printStackTrace();
		}
		
	}


	
	public List<T> buscarTodos(Class<T> classeObj){
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		return (List<T>) session.createQuery("select t from " + classeObj.getSimpleName() + " t order by id", classeObj).getResultList();

	}
	
	public T listaPorId(Class<T> classeObj, Object id) {

		Session session = HibernateConfig.getSessionFactory().openSession();
		
		try {
			
			return session.find(classeObj, id);
	
		} finally {
			
			session.close();
		}
		
	}
	
	public void remove(Class<T> clazz, Object id){
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		T t = listaPorId(clazz, id);
		
		try{
			
			session.getTransaction().begin();
			
			session.remove(t);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			
			session.getTransaction().rollback();
		}
	}


	public Fornecedor listaPorId(Class<Fornecedor> classeObj, int id) {
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		try {
			
			return session.find(classeObj, id);
	
		} finally {
			
			session.close();
			
		}
	}
}
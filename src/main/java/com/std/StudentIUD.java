package com.std;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentIUD {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Amol");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	Student s=new Student();
	
	public void Insetr() {
		System.out.println("inter a id");
		int id=sc.nextInt();
		System.out.println("inter a First name");
		String name1=sc.next();
		System.out.println("inter a Last name");
		String name2=sc.next();
		String name=name1+" "+name2;
		System.out.println("inter a age");
		int age=sc.nextInt();
		System.out.println("inter a Date Of Birth");
		String dob=sc.next();
		System.out.println("inter School Name");
		String scname=sc.next();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setDateofbirth(dob);
		s.setSchoolname(scname);
		
		et.begin();
		em.persist(s);
		et.commit();
		
	}
	
	public void Update() {
		System.out.println("inter a id");
		int id=sc.nextInt();
		Student s=em.find(Student.class, id);
		System.out.println("inter a First name");
		String name1=sc.next();
		System.out.println("inter a Last name");
		String name2=sc.next();
		String name=name1+" "+name2;
		System.out.println("inter a age");
		int age=sc.nextInt();
		System.out.println("inter a Date Of Birth");
		String dob=sc.next();
		System.out.println("inter a School Name");
		String scname=sc.next();
		
		
		s.setName(name);
		s.setAge(age);
		s.setDateofbirth(dob);
		s.setSchoolname(scname);
		
		
		et.begin();
		em.merge(s);
		et.commit();
		
	}
	
	public void Delete() {
		System.out.println("inter a id");
		int id=sc.nextInt();
		
		Student s=em.find(Student.class, id);
		et.begin();
		em.remove(s);
		et.commit();
		
		
	}
	
	public void Display() {
		
		System.out.println("inter a id");
		int id=sc.nextInt();
		Student s=em.find(Student.class, id);
		
		System.out.println("--------------------------------------------------");
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getDateofbirth());
		System.out.println(s.getSchoolname());
		System.out.println("--------------------------------------------------");	
	}
	public void AllDataView() {
	
		Query q=em.createQuery("select a from Student a");
		
		List<Student> s1=q.getResultList();
		System.out.println("-----------------------------------------------------------");
		System.out.println("id\tName\t\tAge\tDOB\t\tSchool");
		System.out.println("-----------------------------------------------------------");
		for (Student s : s1) {
			System.out.print(s.getId()+"\t");
			System.out.print(s.getName()+"\t");
			System.out.print(s.getAge()+"\t");
			System.out.print(s.getDateofbirth()+"\t");
			System.out.println(s.getSchoolname());
			System.out.println("-----------------------------------------------------------");
		}
		
		
	}
	
}

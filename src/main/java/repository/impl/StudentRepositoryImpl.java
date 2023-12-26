package repository.impl;

import entity.person.Student;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
@SuppressWarnings("unused")
public class StudentRepositoryImpl extends PersonRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


//    @Override
//    public boolean isMarried(Integer id) {
//        try {
//            String sql = "select count(s.married) from Student"
//                    + " s where s.id = :id";
//            TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
//            query.setParameter("id", id);
//            return query.getSingleResult() > 0;
//        } catch (Exception e) {
//            System.out.println(new IllegalArgumentException("*This ID Does Not Exist*\n").getMessage());
//            return false;
//        }
//    }
//
//    @Override
//    public boolean gotMortgageLoan(Integer id) {
//        try {
//            String sql = "select count(s.gotMortgageInThisGrade) from Student"
//                    + " s where s.id = :id";
//            TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
//            query.setParameter("id", id);
//            return query.getSingleResult() > 0;
//        } catch (Exception e) {
//            System.out.println(new IllegalArgumentException("*This ID Does Not Exist*\n").getMessage());
//            return false;
//        }
//    }


    @Override
    public boolean existsByNationalId(String nationalId) {
        try {
            String sql = "select count(s.nationalId) from Student s where s.nationalId = :nationalId";
            TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
            query.setParameter("nationalId", nationalId);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            System.out.println(new IllegalArgumentException("*This NationalId is not Found*\n").getMessage());
            return false;
        }
    }
    @Override
    public boolean existByUserNameAndPassword(String username, String password) {
        try {
            String sql = "select count(u.username) from Student u where u.username = :username And u.password = :password";
            TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            System.out.println(new IllegalArgumentException("*This username or password is not Found *\n").getMessage());
            return false;
        }
    }

    @Override
    public Student findByUserName(String username) {
        try {
            String hql = "FROM Student t WHERE t.username = :username";
            TypedQuery<Student> query = entityManager.createQuery(hql, getEntityClass());
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student findByNationalId(String nationalId) {
        try {
            String hql = "FROM Student t WHERE t.nationalId = :nationalId";
            TypedQuery<Student> query = entityManager.createQuery(hql, getEntityClass());
            query.setParameter("nationalId", nationalId);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean existByUserName(String username) {
            try {
                String sql = "select count(s.username) from Student s where s.username = :username";
                TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
                query.setParameter("username", username);
                return query.getSingleResult() > 0;
            } catch (Exception e) {
                System.out.println(new IllegalArgumentException("*This username is not Found*\n").getMessage());
                return false;
            }
        }


    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}

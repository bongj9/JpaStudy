package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("teamA");
            //영속성 컨텍스 트로 추가
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.changeTeam(team);
            em.persist(member);

            //영속성컨텍스트에 있는 값들을 데이터베이스로 날려버려서 싱크를 맞춘다
            em.flush();
            //영속성컨텍스트 초기화
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

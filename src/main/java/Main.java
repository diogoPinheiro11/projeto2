import entity.Manager;
import entity.PostalCode;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            PostalCode postalCode = new PostalCode();
            postalCode.setId("4905-035");
            postalCode.setDescription("teste123");
            entityManager.persist(postalCode);

            Manager pedro = new Manager();
            pedro.setId(10);
            pedro.setName("Pedro Dantas");
            pedro.setPhone("917934982");
            pedro.setStreet("Rua das travessas");
            pedro.setDoor(150);
            pedro.setPostalCodeByPostal(postalCode);
            pedro.setIdType(1);
            entityManager.persist(pedro);


            transaction.commit();
        }finally{
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

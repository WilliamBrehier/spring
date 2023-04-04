package fr.brehierwilliam.cefim.feature.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public List<String> getProductNameList(){
        Query query = entityManager.createNativeQuery("SELECT nom FROM produit;");
        List<String> results = ((List<String>) query.getResultList());
        return results;
    }

    public List<Tuple> getProductList(){
        Query query = entityManager.createNativeQuery("SELECT * FROM produit;", Tuple.class);
        List<Tuple> results = ((List<Tuple>) query.getResultList());
        return results;
    }

}

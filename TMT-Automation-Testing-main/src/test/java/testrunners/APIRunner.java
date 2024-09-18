package testrunners;

import com.intuit.karate.junit5.Karate;

class APIRunner {

    @Karate.Test
    Karate testUsers() {
//        return Karate.run("classpath:Feature/Products.feature").tags("@all").relativeTo(getClass());
        return Karate.run("classpath:Feature/Products.feature").tags("@allproducts").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@oneproduct").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@Limitresult").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@Sortingresult").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@allcategories").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@specific_categry").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@new").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@update").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@delete").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@Daterange").relativeTo(getClass())
//        return Karate.run("classpath:Feature/Products.feature").tags("@newuser").relativeTo(getClass());
//        return Karate.run("classpath:Feature/Products.feature").tags("@login").relativeTo(getClass());




    }


}
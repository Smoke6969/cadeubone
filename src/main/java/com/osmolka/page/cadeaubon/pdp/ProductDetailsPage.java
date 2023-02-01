package com.osmolka.page.cadeaubon.pdp;

import com.osmolka.fw.annotation.Page;
import com.osmolka.page.Base;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class ProductDetailsPage extends Base {

    @Autowired
    DetailsComponent details;
    @Autowired
    UserDataComponent userDataComponent;

    public DetailsComponent details() {
        return details;
    }

    public UserDataComponent userData() {
        return userDataComponent;
    }

    @Override
    public boolean isOpened() {
        return details.isOpened();
    }
}

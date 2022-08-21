package com.ahd.prodcut.model;

import java.util.ArrayList;
import java.util.List;

public class CityResponse {
        private List<Citys> citys;

        public  CityResponse() {
            citys = new ArrayList<>();
        }

    public List<Citys> getCitys() {
        return citys;
    }

    public void setCitys(List<Citys> citys) {
        this.citys = citys;
    }
}

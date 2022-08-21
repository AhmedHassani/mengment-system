package com.ahd.prodcut.service;

import com.ahd.prodcut.model.Pordcut;
import com.ahd.util.WindowType;

public interface Sender {
    void dataSend(Pordcut pordcut, WindowType windowType);
}

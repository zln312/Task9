package com.service;

import com.model.Excellent;
import org.oasisopen.sca.annotation.Remotable;


import java.util.List;

@Remotable
public interface ExcellentService {
    List<Excellent> show();

    long showCount(int status);
}

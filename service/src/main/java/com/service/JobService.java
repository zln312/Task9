package com.service;

import com.model.Job;
import org.oasisopen.sca.annotation.Remotable;


import java.util.List;



@Remotable
public interface JobService {

    List<Job> show();
}

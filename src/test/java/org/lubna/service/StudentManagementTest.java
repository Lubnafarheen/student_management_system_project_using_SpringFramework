package org.lubna.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.lubna.config.ComponentScanConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentManagementTest {

}

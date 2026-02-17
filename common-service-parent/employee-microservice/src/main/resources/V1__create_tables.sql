CREATE TABLE employee_roles (
                                status VARCHAR(20) DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'INACTIVE', 'VACATION', 'SICK_LEAVE')),
                                role_id INTEGER REFERENCES employee_roles(id),
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица навыков мастеров
CREATE TABLE employee_skills (
                                 id SERIAL PRIMARY KEY,
                                 skill_name VARCHAR(100) NOT NULL,
                                 description TEXT,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Связь сотрудников с навыками (многие ко многим)
CREATE TABLE employee_skill_mapping (
                                        employee_id INTEGER REFERENCES employees(id) ON DELETE CASCADE,
                                        skill_id INTEGER REFERENCES employee_skills(id) ON DELETE CASCADE,
                                        proficiency_level VARCHAR(20) DEFAULT 'INTERMEDIATE' CHECK (proficiency_level IN ('BEGINNER', 'INTERMEDIATE', 'ADVANCED', 'EXPERT')),
                                        certified BOOLEAN DEFAULT false,
                                        certified_date DATE,
                                        PRIMARY KEY (employee_id, skill_id)
);

-- Таблица расписания работы
CREATE TABLE employee_schedules (
                                    id SERIAL PRIMARY KEY,
                                    employee_id INTEGER REFERENCES employees(id) ON DELETE CASCADE,
                                    work_date DATE NOT NULL,
                                    start_time TIME NOT NULL,
                                    end_time TIME NOT NULL,
                                    break_start TIME,
                                    break_end TIME,
                                    is_working_day BOOLEAN DEFAULT true,
                                    notes TEXT,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    UNIQUE (employee_id, work_date)
);

-- Таблица статистики по мастерам
CREATE TABLE employee_statistics (
                                     id SERIAL PRIMARY KEY,
                                     employee_id INTEGER REFERENCES employees(id) ON DELETE CASCADE,
                                     month_year DATE NOT NULL,
                                     total_requests INTEGER DEFAULT 0,
                                     completed_requests INTEGER DEFAULT 0,
                                     cancelled_requests INTEGER DEFAULT 0,
                                     total_work_hours DECIMAL(5,2) DEFAULT 0,
                                     average_completion_time DECIMAL(5,2) DEFAULT 0, -- в часах
                                     rating DECIMAL(3,2) DEFAULT 0.0 CHECK (rating >= 0 AND rating <= 5),
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     UNIQUE (employee_id, month_year)
);

-- Индексы для оптимизации
CREATE INDEX idx_employees_status ON employees(status);
CREATE INDEX idx_employees_role ON employees(role_id);
CREATE INDEX idx_schedules_date ON employee_schedules(work_date);
CREATE INDEX idx_schedules_employee_date ON employee_schedules(employee_id, work_date);
CREATE INDEX idx_statistics_month ON employee_statistics(month_year);
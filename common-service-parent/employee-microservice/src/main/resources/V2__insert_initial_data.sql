
INSERT INTO employee_roles (role_name, description) VALUES
('MASTER', 'Мастер автосервиса - выполняет ремонтные работы'),
('ADMINISTRATOR', 'Администратор - прием заявок, общение с клиентами'),
('MANAGER', 'Менеджер - управление заявками, планирование работ'),
('DIRECTOR', 'Директор - управление автосервисом'),
('WAREHOUSE_KEEPER', 'Кладовщик - управление запчастями');

-- Начальные навыки
INSERT INTO employee_skills (skill_name, description) VALUES
                                                          ('ENGINE_REPAIR', 'Ремонт двигателя'),
                                                          ('TRANSMISSION_REPAIR', 'Ремонт трансмиссии'),
                                                          ('BRAKE_SYSTEM', 'Ремонт тормозной системы'),
                                                          ('SUSPENSION', 'Ремонт подвески'),
                                                          ('ELECTRICAL_SYSTEM', 'Ремонт электрооборудования'),
                                                          ('BODY_WORK', 'Кузовные работы'),
                                                          ('PAINTING', 'Покраска автомобилей'),
                                                          ('DIAGNOSTICS', 'Компьютерная диагностика'),
                                                          ('TIRE_SERVICE', 'Шиномонтажные работы'),
                                                          ('OIL_CHANGE', 'Замена масла и фильтров');

-- Триггер для обновления updated_at
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_employees_updated_at BEFORE UPDATE ON employees
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_roles_updated_at BEFORE UPDATE ON employee_roles
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_skills_updated_at BEFORE UPDATE ON employee_skills
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_schedules_updated_at BEFORE UPDATE ON employee_schedules
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_statistics_updated_at BEFORE UPDATE ON employee_statistics
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
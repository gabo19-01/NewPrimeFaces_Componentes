DELIMITER $$
USE `componentecorreos`$$
-- triggers usuario
CREATE DEFINER=`root`@`localhost` TRIGGER `usuario_AFTER_INSERT` AFTER INSERT ON `usuario` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","usuario",NEW.usuarioID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `usuario_AFTER_UPDATE` AFTER UPDATE ON `usuario` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","usuario",NEW.usuarioID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `usuario_AFTER_DELETE` AFTER DELETE ON `usuario` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","usuario",OLD.usuarioID, now());
END$$

-- triggers alerta
CREATE DEFINER=`root`@`localhost` TRIGGER `alerta_AFTER_INSERT` AFTER INSERT ON `alerta` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","alerta",NEW.alertaID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `alerta_AFTER_UPDATE` AFTER UPDATE ON `alerta` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","alerta",NEW.alertaID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `alerta_AFTER_DELETE` AFTER DELETE ON `alerta` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","alerta",OLD.alertaID, now());
END$$

-- triggers categoria
CREATE DEFINER=`root`@`localhost` TRIGGER `categoria_AFTER_INSERT` AFTER INSERT ON `categoria` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","categoria",NEW.categoriaID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `categoria_AFTER_UPDATE` AFTER UPDATE ON `categoria` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","categoria",NEW.categoriaID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `categoria_AFTER_DELETE` AFTER DELETE ON `categoria` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","categoria",OLD.categoriaID, now());
END$$

-- triggers cliente
CREATE DEFINER=`root`@`localhost` TRIGGER `cliente_AFTER_INSERT` AFTER INSERT ON `cliente` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","cliente",NEW.clienteID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `cliente_AFTER_UPDATE` AFTER UPDATE ON `cliente` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","cliente",NEW.clienteID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `cliente_AFTER_DELETE` AFTER DELETE ON `cliente` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","cliente",OLD.clienteID, now());
END$$


-- triggers compania
CREATE DEFINER=`root`@`localhost` TRIGGER `compania_AFTER_INSERT` AFTER INSERT ON `compania` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","compania",NEW.companiaID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `compania_AFTER_UPDATE` AFTER UPDATE ON `compania` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","compania",NEW.companiaID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `compania_AFTER_DELETE` AFTER DELETE ON `compania` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","compania",OLD.companiaID, now());
END$$

-- triggers departamento
CREATE DEFINER=`root`@`localhost` TRIGGER `departamento_AFTER_INSERT` AFTER INSERT ON `departamento` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","departamento",NEW.departamentoID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `departamento_AFTER_UPDATE` AFTER UPDATE ON `departamento` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","departamento",NEW.departamentoID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `departamento_AFTER_DELETE` AFTER DELETE ON `departamento` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","departamento",OLD.departamentoID, now());
END$$

-- triggers evento
CREATE DEFINER=`root`@`localhost` TRIGGER `evento_AFTER_INSERT` AFTER INSERT ON `evento` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","evento",NEW.eventoID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `evento_AFTER_UPDATE` AFTER UPDATE ON `evento` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","evento",NEW.eventoID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `evento_AFTER_DELETE` AFTER DELETE ON `evento` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","evento",OLD.eventoID, now());
END$$

-- triggers hardware
CREATE DEFINER=`root`@`localhost` TRIGGER `hardware_AFTER_INSERT` AFTER INSERT ON `hardware` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","hardware",NEW.hardwareID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `hardware_AFTER_UPDATE` AFTER UPDATE ON `hardware` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","hardware",NEW.hardwareID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `hardware_AFTER_DELETE` AFTER DELETE ON `hardware` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","hardware",OLD.hardwareID, now());
END$$

-- triggers individuo
CREATE DEFINER=`root`@`localhost` TRIGGER `individuo_AFTER_INSERT` AFTER INSERT ON `individuo` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","individuo",NEW.individuoID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `individuo_AFTER_UPDATE` AFTER UPDATE ON `individuo` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","individuo",NEW.individuoID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `individuo_AFTER_DELETE` AFTER DELETE ON `individuo` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","individuo",OLD.individuoID, now());
END$$

-- triggers itemorden
CREATE DEFINER=`root`@`localhost` TRIGGER `itemorden_AFTER_INSERT` AFTER INSERT ON `itemorden` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","itemorden",NEW.itemordenID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `itemorden_AFTER_UPDATE` AFTER UPDATE ON `itemorden` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","itemorden",NEW.itemordenID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `itemorden_AFTER_DELETE` AFTER DELETE ON `itemorden` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","itemorden",OLD.itemordenID, now());
END$$

-- triggers job
CREATE DEFINER=`root`@`localhost` TRIGGER `job_AFTER_INSERT` AFTER INSERT ON `job` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","job",NEW.jobID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `job_AFTER_UPDATE` AFTER UPDATE ON `job` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","job",NEW.jobID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `job_AFTER_DELETE` AFTER DELETE ON `job` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","job",OLD.jobID, now());
END$$

-- triggers manual
CREATE DEFINER=`root`@`localhost` TRIGGER `manual_AFTER_INSERT` AFTER INSERT ON `manual` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","manual",NEW.manualID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `manual_AFTER_UPDATE` AFTER UPDATE ON `manual` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","manual",NEW.manualID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `manual_AFTER_DELETE` AFTER DELETE ON `manual` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","manual",OLD.manualID, now());
END$$


-- triggers orden
CREATE DEFINER=`root`@`localhost` TRIGGER `orden_AFTER_INSERT` AFTER INSERT ON `orden` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","orden",NEW.ordenID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `orden_AFTER_UPDATE` AFTER UPDATE ON `orden` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","orden",NEW.ordenID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `orden_AFTER_DELETE` AFTER DELETE ON `orden` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","orden",OLD.ordenID, now());
END$$

-- triggers producto
CREATE DEFINER=`root`@`localhost` TRIGGER `producto_AFTER_INSERT` AFTER INSERT ON `producto` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","producto",NEW.productoID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `producto_AFTER_UPDATE` AFTER UPDATE ON `producto` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","producto",NEW.productoID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `producto_AFTER_DELETE` AFTER DELETE ON `producto` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","producto",OLD.productoID, now());
END$$

-- triggers software
CREATE DEFINER=`root`@`localhost` TRIGGER `software_AFTER_INSERT` AFTER INSERT ON `software` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","software",NEW.softwareID, now()); 
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `software_AFTER_UPDATE` AFTER UPDATE ON `software` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","software",NEW.softwareID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `software_AFTER_DELETE` AFTER DELETE ON `software` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","software",OLD.softwareID, now());
END$$


-- triggers tipocliente
CREATE DEFINER=`root`@`localhost` TRIGGER `tipocliente_AFTER_INSERT` AFTER INSERT ON `tipocliente` FOR EACH ROW BEGIN
	insert into bitacora (accion, entidad, entidadID, fechaHora) values ("insert","tipocliente",NEW.tipoclienteID, now()); 
END$$


CREATE DEFINER=`root`@`localhost` TRIGGER `tipocliente_AFTER_UPDATE` AFTER UPDATE ON `tipocliente` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("update","tipocliente",NEW.tipoclienteID, now());
END$$

CREATE DEFINER=`root`@`localhost` TRIGGER `tipocliente_AFTER_DELETE` AFTER DELETE ON `tipocliente` FOR EACH ROW BEGIN
insert into bitacora (accion, entidad, entidadID, fechaHora) values ("delete","tipocliente",OLD.tipoclienteID, now());
END$$
DELIMITER ;
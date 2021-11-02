# User Admin
INSERT INTO `db_hc`.`users` (`cedula_identy`, `create_at`, `email`, `lastname`, `name`, `password`, `enable`, `telefone_number`, `direction`) VALUES ('1094353155', '9999-12-31', 'yined.molina@gmail.com', 'Molina', 'Yined', '$2a$10$bX0fYvLPoFo87etkBu4wxu5mlbjMRy2EHqVix9ecYmDpSsgKPFXIS', 1, '3212272989', 'Giron');
INSERT INTO `db_hc`.`users` (`cedula_identy`, `create_at`, `email`, `lastname`, `name`, `password`, `enable`, `telefone_number`, `direction`) VALUES ('1094353155', '9999-12-31', 'user@gmail.com', 'User', 'Name', '$2a$10$s7.JXH1PtnTuqteSWsvNZ.WvLm/R3B0NcuT0qWnu4AKzEXlwpmcZ.', 1, '3212272989', 'Santander');

# Role
INSERT INTO `db_hc`.`role` (`user_id`, `role`) VALUES ('1', 'ROLE_USER');
INSERT INTO `db_hc`.`role` (`user_id`, `role`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `db_hc`.`role` (`user_id`, `role`) VALUES ('2', 'ROLE_USER');

# Status
INSERT INTO `db_hc`.`pets_status` (`name`) VALUES ('Perdido');
INSERT INTO `db_hc`.`pets_status` (`name`) VALUES ('Encontrado');

# Type
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('perro');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('gato');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('conejo');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('ave');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('caballo');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('marmota');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('tortuga');
INSERT INTO `db_hc`.`pets_types` (`name`) VALUES ('reptil');

# Size
INSERT INTO `db_hc`.`pets_sizes` (`name`) VALUES ('grande');
INSERT INTO `db_hc`.`pets_sizes` (`name`) VALUES ('mediano-grande');
INSERT INTO `db_hc`.`pets_sizes` (`name`) VALUES ('mediano-pequeno');
INSERT INTO `db_hc`.`pets_sizes` (`name`) VALUES ('pequeno');

# Breeds
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Beagle');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Bichón Habanero');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Border Collie');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Boyero de Berna');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Bulldog francés');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Caniche');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Carlino');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Cavalier King Charles Spaniel');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Chihuahua');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Cocker Spaniel');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Collie');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Cotón de Tuléar');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Crestado rodesiano');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Golden retriever');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Husky Siberiano');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Jack russell terrier');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Labrador Retriever');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Pastor Alemán');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Pastor Australiano');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Pastor de shetland');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Perro de granja danés y sueco');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Perro finlandés de laponia');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Pomerania');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Retriever de pelo liso');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Rottweiler');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Schnauzer miniatura');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Setter Inglés');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Shih tzu');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Staffordshire Bull Terrier');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Teckel');
INSERT INTO `db_hc`.`pets_breeds` (`name`) VALUES ('Yorkshire Terrier');

# Mascota
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '2', '5');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '1', '4');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '1', '3');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '2', '2');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '2', '1');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '2', '5');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '1', '4');
INSERT INTO `db_hc`.`pets` (`color`, `description`, `name`, `photo`, `years`, `pet_breed_id`, `pet_size_id`, `pet_status_id`, `pet_type_id`) VALUES ('#008080', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, sapiente fugiat architecto nesciunt animi quasi expedita tempora velit mollitia soluta necessitatibus molestiae saepe iure recusandae repellendus ducimus voluptatum officiis laboriosam?', 'Mascota Test', '0.jpg', '3', '13', '3', '1', '3');

# Post
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '1', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '2', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '3', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '4', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '5', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '6', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '7', '1');
INSERT INTO `db_hc`.`posts` (`create_at`, `create_in`, `direction`, `name`, `telefone_number`, `pet_id`, `user_id`) VALUES ('2021-11-01', '2021-11-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo', 'Maria Linda', '000-000-000', '8', '1');
INSERT INTO votos(usuario,fecha,cancion) VALUES ('02elsa',curdate(),7);
UPDATE canciones SET total_votos=total_votos+1 WHERE numcancion=7;
UPDATE usuarios SET numvotos=numvotos+1 WHERE user='02elsa';
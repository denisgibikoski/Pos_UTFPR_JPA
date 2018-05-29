/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  denis
 * Created: 29/05/2018
 *Liste os titulos dos livros que brasileiros avaliaram e as suas notas.
select usuario from Usuario usuario
JOIN usuario.pessoa pessoa
WHERE usuario.senha = :senha
AND pessoa.matricula = :matricula

 */

--Liste os titulos dos livros que brasileiros avaliaram e as suas notas.

SELECT  l.title, a.rating
 From Avaliacao  a 
                  join   a.usario u 
                  join   a.livro l 
                       WHERE u.location like '%USA%';



	


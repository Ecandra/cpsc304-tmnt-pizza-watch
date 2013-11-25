SELECT *
FROM Users;

SELECT SUM(p.price) 
FROM Users u, PizzaOrder po, Pizza p
WHERE u.userID = po.userID AND po.pizzaType = p.PizzaType 
GROUP BY u.userID;

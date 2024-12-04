#!/bin/bash

echo "Initializing database data..."

# Insert categories
echo "Inserting categories..."
mysql -u root -p"$MYSQL_ROOT_PASSWORD" "$MYSQL_DATABASE" << EOF
INSERT INTO resto_category VALUES
  (1,'ENTREE'),
  (2,'RESISTANCE'),
  (3,'DESSERT'),
  (4,'BOISSONS');
EOF

# Insert dishes
echo "Inserting dishes..."
mysql -u root -p"$MYSQL_ROOT_PASSWORD" "$MYSQL_DATABASE" << EOF
INSERT INTO resto_dish VALUES
  (1,'Délicieuse salade avec sauce César...','/images/ENTREE1.jpeg','Laitue, Poulet, Croûtons, Parmesan','GOUAGOUASSOU',2500,1),
  (2,'Pain grillé avec tomates fraîches...','/images/ENTREE2.jpeg','Pain, Tomates, Basilic, Ail','Bruschetta',1500,1);
EOF

# Insert orders
echo "Inserting orders..."
mysql -u root -p"$MYSQL_ROOT_PASSWORD" "$MYSQL_DATABASE" << EOF
INSERT INTO resto_order VALUES
  (3,'SERVI',NULL,'2024-12-03'),
  (6,'EN_ATTENTE','6','2024-12-03'),
  (7,'EN_ATTENTE','6','2024-12-02');
EOF

# Insert order items
echo "Inserting order items..."
mysql -u root -p"$MYSQL_ROOT_PASSWORD" "$MYSQL_DATABASE" << EOF
INSERT INTO resto_order_item VALUES
  (1,'/images/ENTREE1.jpeg','GOUAGOUASSOU',NULL,2500,1,3),
  (3,'https://d165zz1olxm90a.cloudfront.net/eyJidWNrZXQiOiJhZGMtcHJvZC1pbWFnZXMtcmVjaXBlcyIsImtleSI6InNnd3hpbmY5NzNnNzVlc3cyb3JyLmpwZyIsImVkaXRzIjp7ImpwZWciOnsicXVhbGl0eSI6ODB9LCJwbmciOnsicXVhbGl0eSI6ODB9LCJ3ZWJwIjp7InF1YWxpdHkiOjgwfX19','Tatin de raclette','Emporter',1200,2,9);
EOF

echo "Data insertion completed!"

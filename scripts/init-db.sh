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


echo "Data insertion completed!"

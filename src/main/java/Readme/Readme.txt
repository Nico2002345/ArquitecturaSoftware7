Al agregar la anotación @OneToMany(mappedBy = "competitor") en la entidad Competitor, se establece una relación unidireccional de uno a muchos entre Competitor
y Producto, lo que indica que un competidor puede estar asociado a múltiples productos. Esta relación afecta directamente la estructura de la tabla Producto 
en la base de datos, ya que provoca la creación de una columna adicional que actúa como clave foránea (foreign key) apuntando a la tabla Competitor. 
Es decir, la tabla Producto incluirá automáticamente una columna (por ejemplo, COMPETITOR_ID) que referencia al identificador primario de la tabla Competitor, 
permitiendo enlazar cada producto con su competidor asociado y mantener la integridad referencial entre ambas entidades.


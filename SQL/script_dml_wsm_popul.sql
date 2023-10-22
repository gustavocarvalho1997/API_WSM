INSERT INTO t_wsm_categoria (
    id_categoria,
    nm_categoria,
    st_perecivel
) VALUES (
    seq_wsm_categoria.nextval,
    'Laticínios',
    1
);

INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Minas', 20, 1, 'Minas', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Prato', 25, 1, 'Prato', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Mussarela', 30, 1, 'Mussarela', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Provolone', 35, 1, 'Provolone', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Parmesão', 40, 1, 'Parmesão', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Gorgonzola', 45, 1, 'Gorgonzola', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Roquefort', 50, 1, 'Roquefort', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Brie', 55, 1, 'Brie', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Camembert', 60, 1, 'Camembert', 1);
INSERT INTO t_wsm_produto (id_produto, nm_produto, pc_produto, ps_produto, tp_produto, id_categoria) 
VALUES (seq_wsm_produto.nextval, 'Queijo Cheddar', 65, 1, 'Cheddar', 1);

COMMIT;
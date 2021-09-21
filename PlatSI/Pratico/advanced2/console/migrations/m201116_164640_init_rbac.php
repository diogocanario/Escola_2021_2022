<?php

use yii\db\Migration;

/**
 * Class m201116_164640_init_rbac
 */
class m201116_164640_init_rbac extends Migration
{
    /**
     * {@inheritdoc}
     */
    public function safeUp()
    {

    }

    /**
     * {@inheritdoc}
     */
    public function safeDown()
    {
        echo "m201116_164640_init_rbac cannot be reverted.\n";

        return false;
    }



    public function up()
    {
        $auth = Yii::$app->authManager;
        // add "createPost" permission
        $banUser = $auth->createPermission('banUser');
        $banUser->description = 'Banir um utilizador';
        $auth->add($banUser);

        $updateSerie = $auth->createPermission('updateSerie');
        $updateSerie->description = 'Editar dados da serie';
        $auth->add($updateSerie);

        $createComment = $auth->createPermission('createComment');
        $createComment->description = 'Criar comentario';
        $auth->add($createComment);

        $updateComment = $auth->createPermission('updateComment');
        $updateComment->description = 'Atualizar o comentario';
        $auth->add($updateComment);

        $addToFavorites = $auth->createPermission('addToFavorites');
        $addToFavorites->description = 'Adicionar algo aos Favoritos';
        $auth->add( $addToFavorites);

        $deleteFromFavorites = $auth->createPermission('deleteFromFavorites');
        $deleteFromFavorites->description = 'Eleminar algo dos Favoritos';
        $auth->add( $deleteFromFavorites);

        // add "author" role and give this role the "createPost" permission
        $utilizador = $auth->createRole('utilizador');
        $auth->add($utilizador);
        $auth->addChild($utilizador, $createComment);
        $auth->addChild($utilizador, $updateComment);



        // add "admin" role and give this role the "updatePost" permission
        // as well as the permissions of the "author" role
        $admin = $auth->createRole('admin');
        $auth->add($admin);
        $auth->addChild($admin, $utilizador);
    }

    public function down()
    {
        $auth = Yii::$app->authManager;
        $auth->removeAll();
    }

}

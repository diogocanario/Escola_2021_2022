<?php

namespace app\controllers;

use yii\web\Controller;
use yii\data\Pagination;
use app\models\Country;

class CountryController extends Controller
{
    public function actionIndex()
    {
                /*
         
        //get all rows from the country table and order them by "name"
        $countries = Country::find()->orderBy('name')->all();
        
        // get the row whose primary key is "US"
        $country = Country::findOne('US');

        // displays "United States"
        echo $country->name;

        //modifies the country name to be "U.S.A." and save it to database
        $country->name = 'U.S.A.';
        $country->save();
         
        */
        
        $query = Country::find();

        
        
        $pagination = new Pagination([
            'defaultPageSize' => 5,
            'totalCount' => $query->count(),
        ]);

        $countries = $query->orderBy('name')
            ->offset($pagination->offset)
            ->limit($pagination->limit)
            ->all();

        return $this->render('index', [
            'countries' => $countries,
            'pagination' => $pagination,
        ]);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.rumah;

import java.sql.Connection;

/**
 *
 * @author amnesia
 */
public class RumahDaoImplemen implements RumahDao {

    private Connection connection;

    public RumahDaoImplemen(Connection connection) {
        this.connection = connection;
    }

}

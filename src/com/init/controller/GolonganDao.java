/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.controller;

import com.init.entity.Golongan;
import java.util.List;

/**
 *
 * @author Tendy Developer
 */
public interface GolonganDao {

    public List<Golongan> getAllGolongan();

    public void insertGolongan(Golongan golongan);

    public void updateGolongan(Golongan golongan);

    public void deleteGolongan(Golongan golongan);

}

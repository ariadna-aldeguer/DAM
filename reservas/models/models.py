                                                                          
# -*- coding: utf-8 -*-

from odoo import models, fields, api

class Room(models.Model):
        _name = "reserva.room"
        num_hab = fields.Integer(string="Número d'habitació")
        pis = fields.Integer(string="Pis d'habitació")
        tv = fields.Boolean(string="Té televisió?")
        max_pax = fields.Integer(string="Número máxim de persones a una habitació")

class Client(models.Model):
        _name = "reserva.client"
        nom = fields.Char(string="Nom")
        DNI = fields.Char(string="DNI")
        edat = fields.Integer(string="Edat")
        naix = fields.date(String="Data de naixement")


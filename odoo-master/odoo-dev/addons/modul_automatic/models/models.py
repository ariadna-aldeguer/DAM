# -*- coding: utf-8 -*-

 from odoo import models, fields, api


 class /home/alumne/odoo-dev/addons/modul_automatic(models.Model):
     _name = '/home/alumne/odoo-dev/addons/modul_automatic./home/alumne/odoo-dev/addons/modul_automatic'
     _description = '/home/alumne/odoo-dev/addons/modul_automatic./home/alumne/odoo-dev/addons/modul_automatic'

     name = fields.Char()
     value = fields.Integer()
     value2 = fields.Float(compute="_value_pc", store=True)
     description = fields.Text()

     @api.depends('value')
     def _value_pc(self):
         for record in self:
             record.value2 = float(record.value) / 100

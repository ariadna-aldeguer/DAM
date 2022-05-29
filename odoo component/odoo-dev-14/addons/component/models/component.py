# -*- coding: utf-8 -*-

from odoo import models, fields

COLOR = [
	('negre', 'Negre'),
	('plata', 'Plata'),
	('gris', 'Gris'),
]

class Component(models.Model):
	_name = 'gestio.component'
	name = fields.Char(string='Nom del component', required=True)
	marca = fields.Many2one('gestio.marca', string='Marca')
	color = fields.Selection(COLOR, string='Color', default='negre')
	is_offer = fields.Boolean('Té descompte?')


class Marca(models.Model):
	_name = 'gestio.marca'
	name = fields.Char(string='Nombre', required=True)
	nac_fab = fields.Many2one('res.country', string='Nacionalitat')
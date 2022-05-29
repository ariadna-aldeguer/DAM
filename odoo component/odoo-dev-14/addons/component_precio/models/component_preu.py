# -*- coding: utf-8 -*-

from odoo import models, fields

COLOR = [
	('negre', 'Negre'),
	('plata', 'Plata'),
	('gris', 'Gris'),
]

class ComponentPreu(models.Model):
	_inherit = 'gestio.component'
	precio = fields.Float(string='Preu del component')
	color = fields.Selection(COLOR, string='Color', default='gris')
	
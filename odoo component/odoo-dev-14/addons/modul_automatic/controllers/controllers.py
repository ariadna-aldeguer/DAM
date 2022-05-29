# -*- coding: utf-8 -*-
# from odoo import http


# class /home/alumne/odoo-dev/addons/modulAutomatic(http.Controller):
#     @http.route('//home/alumne/odoo-dev/addons/modul_automatic//home/alumne/odoo-dev/addons/modul_automatic/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('//home/alumne/odoo-dev/addons/modul_automatic//home/alumne/odoo-dev/addons/modul_automatic/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('/home/alumne/odoo-dev/addons/modul_automatic.listing', {
#             'root': '//home/alumne/odoo-dev/addons/modul_automatic//home/alumne/odoo-dev/addons/modul_automatic',
#             'objects': http.request.env['/home/alumne/odoo-dev/addons/modul_automatic./home/alumne/odoo-dev/addons/modul_automatic'].search([]),
#         })

#     @http.route('//home/alumne/odoo-dev/addons/modul_automatic//home/alumne/odoo-dev/addons/modul_automatic/objects/<model("/home/alumne/odoo-dev/addons/modul_automatic./home/alumne/odoo-dev/addons/modul_automatic"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('/home/alumne/odoo-dev/addons/modul_automatic.object', {
#             'object': obj
#         })

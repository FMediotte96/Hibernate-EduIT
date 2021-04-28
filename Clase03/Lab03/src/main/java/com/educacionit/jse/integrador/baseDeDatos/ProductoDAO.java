package com.educacionit.jse.integrador.baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.jse.integrador.entidades.Producto;
import com.educacionit.jse.integrador.excepciones.CafeStoreException;
import com.educacionit.jse.integrador.excepciones.NegocioException;

public class ProductoDAO {

	public static void inserta(Producto p) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "insert into Productos (precio, descripcion) values (?,?)";
			st = con.prepareStatement(sql);
			st.setDouble(1, p.getPrecio());
			st.setString(2, p.getDescripcion());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static List<Producto> getProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "select * from Productos";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				double precio = rs.getDouble("precio");
				String desc = rs.getString("descripcion");
				int id = rs.getInt("id");
				p.setDescripcion(desc);
				p.setId(id);
				p.setPrecio(precio);
				productos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return productos;
	}

	public static void modifica(Producto p) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "update Productos set precio = ?, descripcion = ? where id = ?";
			st = con.prepareStatement(sql);
			st.setDouble(1, p.getPrecio());
			st.setString(2, p.getDescripcion());
			st.setInt(3, p.getId());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static void elimina(int id)  {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "delete from Productos where id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Producto getProducto(String descripcion) {
		Connection con = null;
		Producto p = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			try {
				con = AdministradorDeConexiones.obtenerConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "select * from Productos where descripcion  = ?";
			st = con.prepareStatement(sql);
			st.setString(1, descripcion);
			rs = st.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				double precio = rs.getDouble("precio");
				String desc = rs.getString("descripcion");
				p = new Producto();
				p.setDescripcion(desc);
				p.setId(id);
				p.setPrecio(precio);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return p;
	}
	
	public static boolean existe(String descripcion) {
		Connection con = null;
		Producto p = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean respuesta = false;
		try {
			try {
				con = AdministradorDeConexiones.obtenerConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "select * from Productos where descripcion  = ?";
			st = con.prepareStatement(sql);
			st.setString(1, descripcion);
			rs = st.executeQuery();
			if (rs.next()) {
				respuesta = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return respuesta;
	}
	
	public static Producto getProducto(int id) {
		Connection con = null;
		Producto p = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "select * from Productos where id  = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				double precio = rs.getDouble("precio");
				String desc = rs.getString("descripcion");
				p = new Producto();
				p.setDescripcion(desc);
				p.setId(id);
				p.setPrecio(precio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return p;
	}

}
